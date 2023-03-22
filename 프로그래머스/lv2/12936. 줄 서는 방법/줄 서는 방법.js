function solution(n, k) {
    const result = [];
    
    const factory = (num) => {
        let sum = 1;
        for(let i = 1; i <= num; i++){
            sum*=i
        }
        return sum;
    }
    
    let rest = k-1;
     const restArr = Array.from({length: n}, (_, index) => index + 1);
    
    for(let i = 1; i <= n; i++){
        result.push(restArr.splice(Math.floor(rest/factory(n-i)),1));     
        rest = rest%factory(n-i);
    }
    
    return result.flat();
}