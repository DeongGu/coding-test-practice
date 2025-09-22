def solution(participant, completion):
    people = {}
    
    for p in participant:
        if p in people:
            people[p] += 1
        else:
            people[p] = 1
        
    
    for c in completion:
        people[c] -= 1
    
    for i in people:
        if people[i] == 1:
            return i