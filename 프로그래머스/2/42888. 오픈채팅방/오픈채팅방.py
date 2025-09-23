def solution(record):
    history = []
    data = {}
    result = []
    
    for info in record:
        parts = info.split(" ")
        order = parts[0]
        uid = parts[1]
        nickname = parts[2] if len(parts) > 2 else None
        
        if order == "Enter":
            data[uid] = [nickname, 1]
            history.append([uid,1])
        elif order == "Change":
            data[uid][0] = nickname
        else:
            data[uid][1] = 0
            history.append([uid,0])
            
    for uid, isStatus in history:
        if isStatus == 1:
            result.append("".join([data[uid][0],"님이 들어왔습니다."]))
        else:
            result.append("".join([data[uid][0],"님이 나갔습니다."]))
    
    return result