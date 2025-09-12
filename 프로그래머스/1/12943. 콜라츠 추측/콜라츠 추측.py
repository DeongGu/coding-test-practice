def solution(num):

    def recursion(n, cnt):
        
        if n == 1: return cnt
        if cnt == 500 and n != 1: return -1
        
        if n % 2 == 0: n /= 2
        else:
            n = n * 3 + 1
        
        return recursion(n, cnt+1)
        
    return recursion(num, 0)