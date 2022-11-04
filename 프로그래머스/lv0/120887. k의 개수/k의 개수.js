function solution(i, j, k) {
    const result = [];
    
    for(let l = i; l <= j; l++ ){
       result.push(l); 
    }
    
 
    
    return result.join("").split("").filter((el) => el === k.toString()).length;
}