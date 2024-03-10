from collections import deque

A = int(input())
card = list(range(A,0,-1))

d = deque(card)

while len(d) != 1:
  d.pop()
  d.appendleft(d.pop())
  
print(d[0])