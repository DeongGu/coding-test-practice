function solution(n) {
    let result = 1;

    while(result * 7 < n){
        result++;   
    }
    
    return result;
}