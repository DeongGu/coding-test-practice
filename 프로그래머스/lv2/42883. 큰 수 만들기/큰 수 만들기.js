function solution(number, k) {
    const result = [];
    
    for(let i = 0; i < number.length; i++){
        
        const num = number[i];
        
        while( k > 0 && result[result.length-1] < num ){
            result.pop();
            k--;
        }
        
        result.push(num);
        
    }
    
    result.splice(result.length-k, k);
    
    return result.join("");
    
}