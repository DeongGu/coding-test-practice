def solution(mats, park):
    
    mats.sort(reverse=True)
    
    for m in mats:
        for i in range(len(park)):
            for j in range(len(park[i])):
                if park[i][j] != "-1": 
                    continue
                if i + m > len(park) or j + m > len(park[0]): 
                    continue
                    
                check = True
                
                for y in range(i,i+m):
                    for x in range(j,j+m):
                        if park[y][x] != "-1": 
                            check = False
                            break
                    
                    if not check: 
                        break
                
                if check: 
                    return m
                
    return -1