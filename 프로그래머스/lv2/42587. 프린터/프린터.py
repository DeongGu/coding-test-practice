def solution(priorities, location):
    new_priorities = []
    answer_priorities = []
    max_priority = max(priorities)
    
    for idx, i in enumerate(priorities):
        new_priorities.append([idx, i])

    while len(new_priorities) != 0:
        max_priority = max(priorities)
            
        if new_priorities[0][1] == max_priority:
            answer_priorities.append(new_priorities[0])
            new_priorities.pop(0)
            priorities.remove(max(priorities))

        else:
            a = new_priorities.pop(0)
            new_priorities.append(a)
            max_priority = max(priorities)
            
            
    return [idx+1 for idx, content in enumerate(answer_priorities) if content[0] == location][0]
    