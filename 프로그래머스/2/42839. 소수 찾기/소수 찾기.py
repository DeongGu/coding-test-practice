from itertools import permutations

def solution(numbers):
    
    answer = []
    num = []
    numbers = list(numbers)

    for i in range(1, len(numbers) + 1):
           num.append(list(permutations(numbers, i)))
            
    num = [int("".join(y)) for x in num for y in x]
    
    for i in num:
        
        check = True
        
        for j in range(2, int(i**0.5) + 1):
            
            if i % j == 0:
                check = False
                break
    
        if check:
            if i != 1 and i != 0:
                answer.append(i)
            
    return len(list(set(answer)))