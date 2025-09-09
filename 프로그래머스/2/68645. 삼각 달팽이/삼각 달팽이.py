def solution(n):
    answer = []
    
    dr = [1, 0, -1]
    dc = [0, 1, -1]
    r = c = idx = 0
    
    matrix = [[0] * i for i in range(1, n+1)]
    count = n*(n+1) // 2

    num = 1
    
    while num <= count:
        matrix[r][c] = num
        nr = r + dr[idx]
        nc = c + dc[idx]
        num += 1
        
        if 0 <= nr < n and 0 <= nc <= nr and matrix[nr][nc] == 0:
            r, c = nr, nc
        else:
            idx = (idx + 1) % 3
            r = r + dr[idx]
            c = c + dc[idx]
    

    return [i for j in matrix for i in j]