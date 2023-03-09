function solution(n, words) {
    const answer = [0,0];
    
    const stack = [];
    
   for(let i = 0; i < words.length; i++){
        stack.push(words[i]);
        if(stack.length > 1){
            const lastStr = stack[stack.length-1];
            const preStr = stack[stack.length-2];
            
            if(preStr[preStr.length-1] !== lastStr[0]) {
                answer[0] += (i+1)%n === 0 ? n : (i+1)%n;
                answer[1] += Math.floor(i/n)+1;
                return answer;
            }
            
            if(stack.indexOf(words[i]) !== i) {
                answer[0] += (i+1)%n === 0 ? n : (i+1)%n;
                answer[1] += Math.floor(i/n)+1;
                return answer;
            }
        }   
   }
    
    
    return answer;
}