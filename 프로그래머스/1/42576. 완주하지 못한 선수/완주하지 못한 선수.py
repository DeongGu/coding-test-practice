def solution(participant, completion):
    people = {}
    
    for p in participant:
        people[p] = people.get(p, 0) + 1
        
    for c in completion:
        people[c] -= 1
    
    for i in people:
        if people[i]:
            return i