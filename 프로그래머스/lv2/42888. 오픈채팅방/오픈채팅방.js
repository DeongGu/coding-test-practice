function solution(record) {
    const result = [];
    
    const user = {};
    
    for(let i = 0; i < record.length; i++){
        const Record = record[i].split(" ");
        const [action,userId,nickName] = Record;
        if(action === "Enter" || action ==="Change") user[userId] = nickName;
    }
    
    for(let i = 0; i < record.length; i++){
        const Record = record[i].split(" ");
        const [action,userId,nickName] = Record;
        if(action === "Enter"){
            result.push(`${user[userId]}님이 들어왔습니다.`);
        }
        
        if(action === "Leave"){
            result.push(`${user[userId]}님이 나갔습니다.`);
        }
    }
    
    return result;
}