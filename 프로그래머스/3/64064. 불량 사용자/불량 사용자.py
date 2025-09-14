from itertools import permutations
import re
        
def solution(user_id, banned_id):
    answer = set()
    
    ban = " ".join(banned_id).replace("*",".")
    
    for i in permutations(user_id, len(banned_id)):
        
        if re.fullmatch(ban, " ".join(i)):
            answer.add(" ".join(sorted(i)))
    
    return len(answer)