function solution(n) {
    
    let i = 2;
    const result = [];
    
    
    while(n !== 1){
        
       if(n%i === 0){
           n = n/i;
           result.push(i);
           i = 2;
       }else{
           i++;
       }
        
    }
    
    return [...new Set(result)];
}