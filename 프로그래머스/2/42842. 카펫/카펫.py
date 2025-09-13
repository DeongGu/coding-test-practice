def solution(brown, yellow):

    cnt = brown + yellow
    
    for i in range(1, cnt//2):
        
        if cnt % i == 0:
            y = i
            x = cnt // i
            
            if 2*(x+y)-4 == brown:
                return [x,y]