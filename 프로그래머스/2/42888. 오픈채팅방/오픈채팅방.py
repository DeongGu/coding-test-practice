def solution(record):
    history = []
    data = {}
    result = []
    
    for info in record:
        parts = info.split()
        order = parts[0]
        uid = parts[1]
        
        if order in ["Enter", "Change"]:
            nickname = parts[2]
            data[uid] = nickname
            
        history.append((order, uid))
            
    for order, uid in history:
        if order == "Enter":
            result.append("".join([data[uid],"님이 들어왔습니다."]))
        elif order == "Leave":
            result.append("".join([data[uid],"님이 나갔습니다."]))
    
    return result