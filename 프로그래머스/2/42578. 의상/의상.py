def solution(clothes):
    dic = {}
    answer = 1
    
    for name, kind in clothes:
        dic[kind] = dic.get(kind, 0) + 1
    
    for key in dic:
        answer *= dic[key] + 1
    
    return answer - 1
