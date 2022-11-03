function solution(slice, n) {
    let result = 1;
    
    while(slice*result < n){
        result++;
    }
    
    return result;
}