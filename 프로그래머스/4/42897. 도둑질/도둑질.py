def steal(arr):
    n = len(arr)
    
    dp = [0] * n
    
    dp[0] = arr[0]
    dp[1] = max(arr[0], arr[1])
    
    for i in range(2, n):
        dp[i] = max(dp[i-1], dp[i-2] + arr[i]) 
    
    return dp[-1]

def solution(money):
    
    money1 = money[:-1]
    money2 = money[1:]
    
    result1 = steal(money1)
    result2 = steal(money2)
    
    return max(result1, result2)
