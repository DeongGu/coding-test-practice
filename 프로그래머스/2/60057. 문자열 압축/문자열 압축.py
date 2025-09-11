def solution(s):
    answer = len(s)
    
    for i in range(1, len(s) // 2 + 1):
        check_length = 0
        check = ""
        cnt = 1
        
        for c in range(0, len(s) + 1, i):
            tmp = s[c:c+i]
            if check == tmp: cnt += 1
            elif check != tmp:
                check_length += len(tmp)
                if cnt > 1: check_length += len(str(cnt))
                cnt = 1
                check = tmp
        
        answer = min(answer, check_length)
        
    return answer