function solution(a, b, n) {
   let answer = 0;
    
    const repeat = (element) => {
        if(Math.floor(element/a)*b+Math.floor(element%a) < a) {
            answer += Math.floor(element/a)*b;
            return;
        }
        answer += Math.floor(element/a)*b;
        repeat(Math.floor(element/a)*b+Math.floor(element%a));
    }
    
    repeat(n);
    
    return answer;
}