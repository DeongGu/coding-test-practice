def solution(s):
    idx = 0
    result = list(s)
    
    for i, c in enumerate(result):
        if c == " ":
            idx = 0
            continue
        
        if idx % 2 == 0:
            result[i] = result[i].upper()
        else:
            result[i] = result[i].lower()
        
        idx+= 1
    
    return "".join(result)