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
            if a * d == b * c:
                continue  # 평행
            x = (b * f - e * d) / (a * d - b * c)
            y = (e * c - a * f) / (a * d - b * c)
            
            if x == math.trunc(x) and y == math.trunc(y):
                x, y = int(x), int(y)
                dots.add((x, y))
                min_x, max_x = min(min_x, x), max(max_x, x)
                min_y, max_y = min(min_y, y), max(max_y, y)

    r = max_y - min_y + 1
    c = max_x - min_x + 1

    result = [["."] * c for _ in range(r)]
    for x, y in dots:
        result[y - min_y][x - min_x] = "*"
    
    answer = ["".join(row) for row in reversed(result)]
    return answer
