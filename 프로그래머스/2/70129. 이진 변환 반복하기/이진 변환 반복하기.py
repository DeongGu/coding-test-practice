def solution(s):
    c_cnt, z_cnt = 0, 0
    
    while s != "1":
        c_cnt += 1
        cnt = s.count("1")
        z_cnt += len(s) - cnt
        
        s = bin(cnt)[2:]
    
    return [c_cnt, z_cnt]