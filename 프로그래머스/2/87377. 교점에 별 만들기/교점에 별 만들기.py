import math

def solution(line):

    dots = set()
    n = len(line)
    min_x, min_y = float("inf"), float("inf")
    max_x, max_y = float("-inf"), float("-inf")
    
    for i in range(n):
        a, b, e = line[i]

        for j in range(i + 1, n):
            c, d, f = line[j]
            if a * d == b * c: continue
            x = (b * f - e * d) / (a * d - b * c)
            y = (e * c - a * f) / (a * d - b * c)
            
            if x == math.trunc(x) and y == math.trunc(y):
                dots.add((int(x),int(y)))
                
                if x > max_x: max_x = x
                if y > max_y: max_y = y
                if x < min_x: min_x = x
                if y < min_y: min_y = y

        
    r = int(max_y - min_y) + 1
    c = int(max_x - min_x) + 1

    result = [["."] * c for _ in range(r)]
    answer = []
    
    for dot in dots:
        moved_dot_x = dot[0] - int(min_x)
        moved_dot_y = dot[1] - int(min_y)
        result[moved_dot_y][moved_dot_x] = "*"
    
    for el in result:
        answer.append("".join(el))
    
    answer.reverse()
    
    return answer

            