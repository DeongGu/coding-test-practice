def solution(prices):
    
    stack = []
    answer = [0] * len(prices)
    
    for i in range(len(prices)):
        while stack and prices[stack[-1]] > prices[i]:
            p = stack.pop()
            answer[p] = i - p
        stack.append(i)
        
    for i in stack:
        answer[i] = len(prices) - 1 - i
    
    return answer