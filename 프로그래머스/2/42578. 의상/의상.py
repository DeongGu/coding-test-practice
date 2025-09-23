def solution(clothes):
    dic = {}
    answer = 1
    
    for name, kind in clothes:
        if kind in dic:
            dic[kind].append(name)
        else:
            dic[kind] = [name]
    
    for key in dic:
        answer *= (len(dic[key]) + 1)
    
    return answer - 1
