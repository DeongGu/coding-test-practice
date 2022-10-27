def solution(numbers):
    result = sorted(numbers, key=lambda x : str(x)*3, reverse=True)
    answer = ''.join(map(str, result))
    
    return str(int(answer))