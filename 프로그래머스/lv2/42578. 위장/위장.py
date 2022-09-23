def solution(clothes):
    
    new_dict = {}
    
    for cloth in clothes:
        if not cloth[1] in list(new_dict.keys()):
            new_dict[cloth[1]] = [cloth[0]]
        else:
            new_dict[cloth[1]].append(cloth[0])    
    
    if len(list(new_dict.keys())) == 1:
        return len(list(new_dict.values())[0])
    else:
        list_value = [len(value) for value in list(new_dict.values())]
        
        answer = 0
    
        for i in list_value:
            if answer == 0:
                answer = i+1
            else:
                answer *= i+1
                
        return answer - 1
            
    
    
    