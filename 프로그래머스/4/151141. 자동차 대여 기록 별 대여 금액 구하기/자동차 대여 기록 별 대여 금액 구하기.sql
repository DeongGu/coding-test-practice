SELECT 
    H.HISTORY_ID,
    FLOOR(
        C.DAILY_FEE * (DATEDIFF(H.END_DATE, H.START_DATE) + 1) *
        (1 - COALESCE(
            CASE 
                WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 90 THEN (
                    SELECT DISCOUNT_RATE / 100 
                    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
                    WHERE CAR_TYPE = '트럭' AND DURATION_TYPE = '90일 이상'
                )
                WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 30 THEN (
                    SELECT DISCOUNT_RATE / 100 
                    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
                    WHERE CAR_TYPE = '트럭' AND DURATION_TYPE = '30일 이상'
                )
                WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 7 THEN (
                    SELECT DISCOUNT_RATE / 100 
                    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
                    WHERE CAR_TYPE = '트럭' AND DURATION_TYPE = '7일 이상'
                )
                ELSE 0
            END, 0)
        )
    ) AS FEE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
JOIN CAR_RENTAL_COMPANY_CAR C
  ON H.CAR_ID = C.CAR_ID
WHERE C.CAR_TYPE = '트럭'
ORDER BY FEE DESC, H.HISTORY_ID DESC;
