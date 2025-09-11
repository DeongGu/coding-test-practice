def solution(s):
    answer = []
    check = set()
    
    s = s[2: -2]
    arr = [list(map(int, i.split(","))) for i in s.split("},{")]
    arr.sort(key=len)
    
    for li in arr:
        for el in li:
            check.add(el)
            if len(answer) != len(check):
                answer.append(el)
    
    return answer
