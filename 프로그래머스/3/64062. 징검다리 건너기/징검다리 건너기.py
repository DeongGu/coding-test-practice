def check(n, stones, k):
    
    cnt = 0
    
    for stone in stones:
        
        if stone < n:
            cnt += 1
            
            if cnt >= k:
                return False
        
        else:
            cnt = 0
        
    return True


def solution(stones, k):
    answer = 0
    
    start, end = 0, max(stones)
    
    while start <= end:
        
        mid = (start + end) // 2
        
        if check(mid,stones,k):
            start = mid + 1
            answer = max(mid, answer)
        else:
            end = mid - 1
    
    return answer