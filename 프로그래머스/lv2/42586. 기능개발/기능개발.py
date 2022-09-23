def solution(progresses, speeds):
    
    new_list = {}
    standard = 0
    
    for idx, i in enumerate(progresses):
        remainder = 100 - i
    
        if remainder % speeds[idx] == 0:
            progress = int(remainder/speeds[idx])
            if standard <= progress:
                standard = progress
            if standard in new_list:
                new_list[standard] += 1
            else:
                new_list[standard] = 1
                                    
                
        elif remainder % speeds[idx] > 0:
            progress = int(remainder/speeds[idx]+1)
            if standard <= progress:
                standard = progress
            if standard in new_list:
                new_list[standard] += 1
            else:
                new_list[standard] = 1
                
    return list(new_list.values())