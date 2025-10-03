def solution(m, n, puddles):
    answer = [[0] * m for _ in range(n)]
    answer[0][0] = 1
    
    skip = set()
    
    for (c,r) in puddles:
        skip.add((r-1,c-1))
    
    for r in range(n):
        for c in range(m):
            if (r, c) in skip:
                answer[r][c] = 0
            else:
                if r > 0:
                    answer[r][c] += answer[r-1][c]
                if c > 0:
                    answer[r][c] += answer[r][c-1]

    return answer[n-1][m-1] % 1000000007