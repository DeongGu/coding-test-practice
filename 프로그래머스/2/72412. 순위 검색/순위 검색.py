from collections import defaultdict
from itertools import combinations
from bisect import bisect_left

def solution(info, query):
    db = defaultdict(list)
    result = []
    for i in info:
        user = i.split()
        score = int(user.pop())
        db["".join(user)].append(score)
    
        for j in range(4):
            arr = list(combinations(user,j))
            for k in arr:
                db["".join(k)].append(score)
                
    for i in db: db[i].sort()
    
    for q in query:
        order = q.split()
        score = int(order.pop())
        
        key = "".join(order).replace("and", "").replace(" ","").replace("-", "")
        result.append(len(db[key]) - bisect_left(db[key], score))
    
    return result
