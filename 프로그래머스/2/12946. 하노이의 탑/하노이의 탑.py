def hanoi(n, start, mid, to, arr):
    if n == 1: return  arr.append([start, to])
    hanoi(n-1, start, to, mid , arr)
    arr.append([start, to])
    hanoi(n-1, mid, start , to, arr)

def solution(n):
    answer = []
    hanoi(n, 1, 2, 3, answer)
    return answer