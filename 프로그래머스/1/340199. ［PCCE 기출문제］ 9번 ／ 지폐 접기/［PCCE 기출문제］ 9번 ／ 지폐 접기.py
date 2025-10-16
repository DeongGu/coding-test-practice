def solution(wallet, bill):
    answer = 0
    
    max_wallet = max(wallet[0], wallet[1])
    max_bill = max(bill[0], bill[1])
    min_wallet = min(wallet[0], wallet[1])
    min_bill = min(bill[0], bill[1])
    
    while min_bill > min_wallet or max_wallet < max_bill:
        if bill[0] > bill[1]:
            bill[0] //= 2
            max_bill = max(bill[0], bill[1])
            min_bill = min(bill[0], bill[1])
        else:
            bill[1] //= 2
            max_bill = max(bill[0], bill[1])
            min_bill = min(bill[0], bill[1])
        
        answer+= 1
    
    return answer