def solution(places):
    answer = []
    
    dr = [-2, 0, 2, 0, -1, -1, 0, 1, 1, 1, 0, -1]
    dc = [0, 2, 0, -2, 0, 1, 1, 1, 0, -1, -1, -1]
    check_dr = [-1, 0, 1, 0, -1, -1, 0, 0, 0, 0, 0, 0]
    check_dc = [0, 1, 0, -1, 0, 0, 0, 1, 0, -1, 0, -1]

    plus_check_dr =  [0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, -1]
    plus_check_dc = [0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0]
    
    for place in places:
        ok = 1
        for r in range(5):
            for c in range(5):
                if place[r][c] == "O" or place[r][c] == "X":
                    continue
                if place[r][c] == "P":
                    valid = True
                    for i in range(12):
                        nr = r + dr[i]
                        nc = c + dc[i]
                        if 0 <= nr < 5 and 0 <= nc < 5:
                            if manhattan(r, c, nr, nc) == 1 and place[nr][nc] == "P":
                                valid = False
                                break
                            if manhattan(r, c, nr, nc) == 2 and place[nr][nc] == "P":
                                cr = r + check_dr[i]
                                cc = c + check_dc[i]
                                if place[cr][cc] != "X":
                                    valid = False
                                    break
                                if i in (5, 7, 9, 11):
                                    pcr = r + plus_check_dr[i]
                                    pcc = c + plus_check_dc[i]
                                    if place[pcr][pcc] != "X":
                                        valid = False
                                        break
                    if not valid:
                        ok = 0
                        break
            if ok == 0:
                break
        answer.append(ok)
    return answer

def manhattan(r1, c1, r2, c2):
    return abs(r1 - r2) + abs(c1 - c2)
