def solution(rows, columns, queries):
    answer = []
    
    matrix = [[(i) * columns + (j+1) for j in range(columns)] for i in range(rows)]
    
    for x1, y1, x2, y2 in queries:
        
        r1 = x1 - 1
        c1 = y1 - 1
        r2 = x2 - 1
        c2 = y2 - 1
        
        result = []
        
        new_matrix = [row[:] for row in matrix]
        
#         r1 일때 c1 ~ c2
        for c in range(c1+1, c2+1):
            new_matrix[r1][c] = matrix[r1][c-1]
            result.append(new_matrix[r1][c])
            
#         c2 일때 r1 ~ r2
        for r in range(r1+1, r2+1):
            new_matrix[r][c2] = matrix[r-1][c2]
            result.append(new_matrix[r][c2])
        
#         r2 일때 c2 ~ c1
        for c in range(c2 - 1, c1 - 1 , -1):
            new_matrix[r2][c] = matrix[r2][c+1]
            result.append(new_matrix[r2][c])
        
#         c1 일때 r2 ~ r1
        for r in range(r2 - 1, r1 - 1 , -1):
            new_matrix[r][c1] = matrix[r+1][c1]
            result.append(new_matrix[r][c1])
        
        answer.append(min(result))
        matrix = new_matrix
    
    return answer