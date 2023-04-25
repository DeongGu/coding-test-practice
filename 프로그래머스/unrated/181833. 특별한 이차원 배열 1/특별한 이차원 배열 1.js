function solution(n) {
    const result = new Array(n).fill(0).map(() => new Array(n).fill(0));
    
    for(let i = 0; i < n; i++){
        result[i][i] = 1;
    }
    return result;
}