function solution(n, k) {
    const result = [];
    
    if(n === 2 && k === 2) return [2,1];
    
    const factory = (num) => {
        let sum = 1;
        for(let i = 1; i <= num; i++){
            sum*=i
        }
        return sum;
    }
    
    let rest = k;
     
    for(let i = 1; i <= n; i++){
        const restArr = Array.from({length: n}, (_, index) => index + 1).filter((el) => !result.includes(el));
        const numOfCases = factory(n - i);
        const index = Math.floor((rest - 1) / numOfCases);
        result.push(restArr[index]);
        rest = rest - (numOfCases * index);
    }
    
    return result;
}