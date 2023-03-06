function solution(k, score) {
    const result = [];
    const list = [];
    
    for(let i = 0; i < score.length; i++){
        list.push(score[i]);
        
        if(list.length === k+1){
            list.sort((a,b) => b-a);
            list.pop();
            result.push(list[list.length-1]);
            continue;
        }
        
        list.sort((a,b) => b-a);
        result.push(list[list.length-1]);
        
    }
    
    return result;
}