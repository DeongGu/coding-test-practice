def solution(line):
    pos, answer = [], []
    n = len(line)
    
    min_x = min_y = int(1e15)
    max_x = max_y = -int(1e15)
    
    for i in range(n):
        a, b, e = line[i]
        for j in range(i + 1, n):
            c, d, f = line[j]
            if a * d == b * c:
                continue
            x = (b * f - e * d) / (a * d - b * c)
            y = (e * c - a * f) / (a * d - b * c)
            
            if x == int(x) and y == int(y):
                x, y = int(x), int(y)
                pos.append([x, y])
                if min_x > x: min_x = x
                if min_y > y: min_y = y
                if max_x < x: max_x = x
                if max_y < y: max_y = y
                

    r = max_y - min_y + 1
    c = max_x - min_x + 1

    result = [["."] * c for _ in range(r)]
    for x, y in pos:
        result[y - min_y][x - min_x] = "*"
    
    answer = ["".join(row) for row in reversed(result)]
    return answer
