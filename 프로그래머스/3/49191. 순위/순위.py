from collections import deque

def solution(n, results):
    answer = 0
    
    win = [[] for _ in range(n+1)]
    lose = [[] for _ in range(n+1)]
    
    for a,b in results:
        win[a].append(b)
        lose[b].append(a)
    
    def bfs(v,li):
        cnt = 0
        visited = [False] * (n+1)
        visited[v] = True
        q = deque([v])
    
        while q:
            nv = q.popleft()
        
            for i in li[nv]:
                if not visited[i]:
                    visited[i] = True
                    q.append(i)
                    cnt+= 1
    
        return cnt
    
    
    for i in range(1,n+1):
        win_cnt = bfs(i,win)
        lose_cnt = bfs(i,lose)
    
        if win_cnt + lose_cnt == n-1:
            answer += 1
    
    
    return answer
            