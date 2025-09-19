def solution(numbers):
    result = set()
    
    for i in range(len(numbers)):
        for j in range(len(numbers)):
            if i == j: continue
            result.add(numbers[i] + numbers[j])
    
    return sorted(list(result))