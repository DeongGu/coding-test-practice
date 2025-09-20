def solution(n, times):
    
    result = 0
    left, right = 1, max(times) * n
    
    while left <= right:
        mid = (left + right) // 2
        people = 0
        for time in times:
            people += mid // time
            if people >= n: break
            
        if people >= n:
            result = mid
            right = mid - 1
        else:
            left = mid + 1
        

    return result