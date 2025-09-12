def recursion(n, cnt):
        
        if n == 1: return cnt
        if cnt == 500: return -1
        
        if n % 2 == 0: 
            return recursion(n // 2, cnt + 1)
        elif n % 2 == 1:
            return recursion(n * 3 + 1, cnt + 1)
        
def solution(num):
    return recursion(num, 0)