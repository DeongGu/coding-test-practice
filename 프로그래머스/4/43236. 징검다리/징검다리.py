def solution(distance, rocks, n):
    answer = 0
    start, end = 0, distance
    
    rocks.sort()
    
    rocks.append(distance)
    
    while start <= end:
        
        mid = (start + end) // 2
        
        cnt = 0
        pre = 0
        
        for rock in rocks:
            if rock - pre < mid:
                cnt += 1
            else:
                pre = rock
        
            if cnt > n: break
            
        if cnt > n:
            end = mid - 1
        else:
            answer = mid
            start = mid + 1
    
    return answer