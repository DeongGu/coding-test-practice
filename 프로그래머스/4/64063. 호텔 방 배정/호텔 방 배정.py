import sys
sys.setrecursionlimit(10 ** 6)

def recursion(n, rooms):
    
    if n not in rooms:
        rooms[n] = n+1
        return n
    
    rooms[n] = recursion(rooms[n], rooms)
    
    return rooms[n]

def solution(k, room_number):
    rooms = {}
    answer = []
    
    for num in room_number:
        answer.append(recursion(num, rooms))
    
    return answer