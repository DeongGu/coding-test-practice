function solution(arr, k) {
    const set = new Set(arr);
    const result = [...set];
    
    if(result.length > k){    
        const count = result.length - k;
        for(let i = 0; i < count; i++){
            result.pop();
        }
    }else{
        const count = k - result.length;
        for(let i = 0; i < count; i++){
            result.push(-1);
        }
    }
    return result;
}