function solution(num_list, n) {
    const result = [];
    const length = num_list.length;
    
    for(let i = 0; i < length/n ; i++){
        
        const answer = [];
        for(let j = 0; j < n; j++){
            answer.push(num_list.shift());
        }
        
        result.push(answer);
    }
    
    return result;
}