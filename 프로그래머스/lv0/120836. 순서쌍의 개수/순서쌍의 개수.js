function solution(n) {
    
    const result = [];
    
    for(let i = 1; i < n**0.5; i++){
        if(n%i === 0){
            result.push(i);
        }    
    }
    
    return n**0.5%1===0 ? result.length*2+1 : result.length*2;
}