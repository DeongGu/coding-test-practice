function solution(n) {
    let result = 1;
    let answer = 1;
    
    while(true){
        answer *= result;
        
        if(n < answer){
            return result - 1;
        }
        result++;
    }    
}