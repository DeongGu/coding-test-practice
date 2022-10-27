def solution(brown, yellow):
    answer = []
    
    result = brown + yellow
    
    for i in range(1,result+1):
        if result**(1/2) == int(result**(1/2)):
            answer = [result**(1/2), result**(1/2)]
            break
            
            
        a,b = divmod(result,i)
        
        if b == 0:
            if i > a:
                break
                
            if (a-2)*(i-2) == yellow:
                answer = [a, i]
                break
            answer = [a,i]
        
    
    return answer