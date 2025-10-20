def solution(n, w, num):
    h = (n + w - 1) // w

    m = [[0] * w for _ in range(h)]
    
    c = 1
    for i in range(h):
        cols = range(w) if i % 2 == 0 else range(w - 1, -1, -1)
        for j in cols:
            if c > n:
                break
            m[i][j] = c
            c += 1

    for i in range(h):
        for j in range(w):
            if m[i][j] == num:
                cnt = 0
                for k in range(i, h):
                    if m[k][j] != 0:
                        cnt += 1
                return cnt
