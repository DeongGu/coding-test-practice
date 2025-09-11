def solution(s):
    answer = []
    check = set()
    
    s = s[2: -2]
    arr = [list(map(int, i.split(","))) for i in s.split("},{")]
    arr.sort(key=len)
    
    for li in arr:
        for el in li:
            if el not in check:
                answer.append(el)
                check.add(el)
    
    return answer

