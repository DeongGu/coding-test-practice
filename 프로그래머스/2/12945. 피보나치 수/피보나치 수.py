def solution(n):
    answer = 0
    arr = [0,1]
    
    for i in range(1, n):
        arr.append(arr[i-1] + arr[i])
    
    return arr[-1] % 1234567