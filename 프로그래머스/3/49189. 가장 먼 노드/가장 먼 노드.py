from collections import deque

def solution(n, edge):
    li = [[] for _ in range(n + 1)]
    for a, b in edge:
        li[a].append(b)
        li[b].append(a)

    dist = [-1] * (n + 1)
    dist[1] = 0

    q = deque([1])
    
    while q:
        v = q.popleft()
        for nv in li[v]:
            if dist[nv] == -1: 
                dist[nv] = dist[v] + 1
                q.append(nv)

    maxd = max(dist[1:])
    return dist.count(maxd)
