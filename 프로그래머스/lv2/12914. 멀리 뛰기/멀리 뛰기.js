function solution(n) {
   if(n === 1) return 1;
    if(n === 2) return 2;
    
    let result = [1,2];
    
    for(let i = 2; i < n; i++){
        result.push(result[i-2]%1234567 + result[i-1]%1234567);
    }
    
    return result[result.length-1]%1234567;
}