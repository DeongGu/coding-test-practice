function solution(n, control) {
    const key = {w:1, s:-1, d:10, a:-10};
    let result = n;
    
    for(const c of control){
        result += key[c];
    }
    
    return result;
}