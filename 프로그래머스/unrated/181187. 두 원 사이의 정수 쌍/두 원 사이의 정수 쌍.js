function solution(r1, r2) {
    let result = 0;
    for(let i = 1; i <= r1; i++){
      result+= Math.floor(Math.sqrt(r2**2 - i**2)) - Math.ceil(Math.sqrt(r1**2 - i**2))+1;
    }
    
    for(let i = r1+1; i <= r2; i++){
        result += Math.floor(Math.sqrt(r2**2-i**2))+1;
    }
 
    return result*4;
}
