def solution(progresses, speeds):
    answer = []
    
    end = 0
    c = 0
    
    for i in range(len(progresses)):
        cur = 100 - progresses[i]    
        day = (cur // speeds[i]) + 1 if cur % speeds[i] != 0 else cur // speeds[i]
        
        if i == 0:
            end = day
        
        if end >= day:
            c += 1
        else:
            answer.append(c)
            c = 1
            end = day
        
    answer.append(c)
        
    return answer