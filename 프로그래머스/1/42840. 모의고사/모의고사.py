def solution(answers):
    answer = []
    h1 = [1,2,3,4,5]
    h2 = [2,1,2,3,2,4,2,5]
    h3 = [3,3,1,1,2,2,4,4,5,5]
    
    cnt = [0,0,0]
    
    for idx, v in enumerate(answers):
        if h1[idx%len(h1)] == v: cnt[0] += 1
        if h2[idx%len(h2)] == v: cnt[1] += 1
        if h3[idx%len(h3)] == v: cnt[2] += 1
        
    max_cnt = max(cnt)

    for idx, v in enumerate(cnt):
        if v == max_cnt:
            answer.append(idx+1)
    
    if len(answer) > 1: answer.sort()
    
    return answer