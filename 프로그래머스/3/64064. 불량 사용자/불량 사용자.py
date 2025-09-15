import re

def dfs(ban_idx, banned, users, visited, picked, answer):
    if ban_idx == len(banned):
        answer.add(tuple(sorted(picked)))
        return
    
    for i in range(len(users)):
        if visited[i] or not re.fullmatch(banned[ban_idx], users[i]):
            continue

        visited[i] = True
        dfs(ban_idx+1, banned, users, visited, picked+[users[i]], answer)
        visited[i] = False

def solution(user_id, banned_id):
    answer = set()
    
    banned = [x.replace("*", ".") for x in banned_id]
    
    visited = [False] * len(user_id)
    dfs(0, banned, user_id, visited, [], answer)
    
    return len(answer)
