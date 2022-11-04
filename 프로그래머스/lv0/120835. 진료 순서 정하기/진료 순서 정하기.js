function solution(emergency) {
    
    let result = [];
    
    for(let i = 0; i < emergency.length; i++){
        
        let count = 1;
        
        for(let j = 0; j < emergency.length; j++){
            if(emergency[i] < emergency[j]){
                count++;
            }
        }
        result.push(count);
    }
    return result;
}