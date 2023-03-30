function solution(bridge_length, weight, truck_weights) {
    const status = new Array(truck_weights.length).fill().map((_,idx) => [truck_weights[idx], 0]);
    
    const stack = [];
    let result = [];
    let answer = 0;
    
    while(result.length !== truck_weights.length){
        
        if(stack[0]?.[1] === bridge_length){
            result.push(stack[0]);
            stack.shift();
        }

        let limit = 0;
        
        stack.map(el => limit+= el[0]);
        
        if(status.length > 0 && weight >= limit + status[0][0]){
            stack.push(status[0]);
            status.shift();
            
            answer++;
            
            stack.map(el => el[1]+=1);
        }else{
            answer++;
            stack.map(el => el[1]+=1);
        }
        
    }
    
    return answer;
}