function solution(n) {
    const result = [n];
    
    while(n !== 1){
        if(n % 2 === 0){
            n = n/2;
            result.push(n);
        }else{
            n = 3 * n + 1;
            result.push(n);
        }
    }
    
    return result;
}