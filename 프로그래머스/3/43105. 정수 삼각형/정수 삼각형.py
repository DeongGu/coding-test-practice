def solution(triangle):
    
    height = len(triangle) - 1
    
    while height > 0:
        
        for i in range(len(triangle[height])-1):
            triangle[height-1][i] += max(triangle[height][i], triangle[height][i+1])
        height -= 1
        
    return triangle[0][0]