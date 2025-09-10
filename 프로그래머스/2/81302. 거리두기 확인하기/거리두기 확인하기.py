def solution(places):
    answer = []

    dr = [0, 2, 0, -1, -1, 0, 1, 1, 1, 0, -1] 
    dc = [2, 0, -2, 0, 1, 1, 1, 0, -1, -1, -1] 
    check_dr = [0, 1, 0, -1, -1, 0, 0, 0, 0, 0, 0] 
    check_dc = [1, 0, -1, 0, 0, 0, 1, 0, -1, 0, -1] 
    plus_check_dr = [0, 0, 0, 0, 0, 0, 1, 0, 1, 0, -1] 
    plus_check_dc = [0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0]

    for place in places:
        def is_valid():
            for r in range(5):
                for c in range(5):
                    if place[r][c] != "P":
                        continue
                    for i in range(11):
                        nr, nc = r + dr[i], c + dc[i]
                        if not (0 <= nr < 5 and 0 <= nc < 5):
                            continue
                        dist = abs(r - nr) + abs(c - nc)
                        if dist == 1 and place[nr][nc] == "P":
                            return False
                        if dist == 2 and place[nr][nc] == "P":
                            cr, cc = r + check_dr[i], c + check_dc[i]
                            if place[cr][cc] != "X":
                                return False
                            if i in (4, 6, 8, 10):
                                pcr, pcc = r + plus_check_dr[i], c + plus_check_dc[i]
                                if place[pcr][pcc] != "X":
                                    return False
            return True

        answer.append(1 if is_valid() else 0)

    return answer