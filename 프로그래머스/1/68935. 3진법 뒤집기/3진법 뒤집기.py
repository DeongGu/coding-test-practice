def solution(n):
    nums = []
    num = n
    while num:
        num, digit = divmod(num, 3)
        nums.append(str(digit))
    
    return int("".join(nums), 3)