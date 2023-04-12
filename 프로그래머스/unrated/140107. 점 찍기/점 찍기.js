function solution(k, d) {
    let result = 0;
    
    for(let i = 0; i <= d; i+=k){
        const y = Math.floor(Math.floor(Math.sqrt(d**2 - i**2))/k)
        result+= y+1;
    }
 
    return result;
}