def solution(s):
    answer = []
    c_cnt = 0
    z_cnt = 0
    
    while s != "1":
        c_cnt += 1
        before_length = len(s)
        s = s.replace("0", "")
        z_cnt += before_length - len(s)
        tmp = len(s)
        nums = []
        while tmp:
            tmp, digit = divmod(tmp, 2)
            nums.append(str(digit))
        
        s = "".join(nums)
    
    return [c_cnt, z_cnt]