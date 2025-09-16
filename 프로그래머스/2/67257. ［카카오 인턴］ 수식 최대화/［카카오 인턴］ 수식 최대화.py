import re
from itertools import permutations

def calculate(nums, ops, order):
    nums = nums[:]
    ops = ops[:]
    
    for op in order:
        stack_nums = [nums[0]]
        stack_ops = []
        
        for i in range(len(ops)):
            if ops[i] == op:
                a = stack_nums.pop()
                b = nums[i+1]
                if op == '+': stack_nums.append(a + b)
                elif op == '-': stack_nums.append(a - b)
                elif op == '*': stack_nums.append(a * b)
            else:
                stack_nums.append(nums[i+1])
                stack_ops.append(ops[i])
        
        nums = stack_nums
        ops = stack_ops
    
    return abs(nums[0])

def solution(expression):
    numbers = list(map(int, re.split(r"[-+*]", expression)))
    operators = re.findall(r"[-+*]", expression)
    
    max_value = 0
    for order in permutations(['-', '+', '*']):
        result = calculate(numbers, operators, order)
        max_value = max(max_value, result)
    
    return max_value
