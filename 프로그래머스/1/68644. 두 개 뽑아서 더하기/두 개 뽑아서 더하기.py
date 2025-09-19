from itertools import combinations

def solution(numbers):
    
    result = set()
    
    selects = list(combinations(numbers, 2))
    
    for select in selects:
        (a,b) = select
        result.add(a+b)
    
    return sorted(list(result))