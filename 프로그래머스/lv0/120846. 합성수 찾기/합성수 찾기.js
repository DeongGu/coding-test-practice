function solution(n) {
   let result = 0;
    
    for(let i = 4; i <= n; i++){
        
        for(let j = 2; j < i; j++){
            
            if( i % j === 0){
                result += 1;
                break;
            }
        }
    }
    return result;
}