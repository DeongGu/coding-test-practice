def solution(n):

    tmp = []
    answer = n
    
    while answer / 3 != 0:
        tmp.append(answer % 3)
        answer = answer // 3
    
    for idx, v in enumerate(list(map(int,tmp))[::-1]):
        answer += (3 ** idx) * v
        
    return answer