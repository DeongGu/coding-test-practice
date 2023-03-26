function solution(n) {
    let result = [1,2];

    if(n <= 2) return result[n-1];
    
    for(let i = 1; i <= n; i++){
        result.push((result[i-1]+result[i])%1000000007);
    }
    
  
    return result[n-1]%1000000007;
   
}
