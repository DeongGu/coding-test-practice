function solution(s)
{
  const stack = [];
  
    for(let i = 0; i < s.length; i++){
        stack.push(s[i]);
        if(stack.length > 1){
           if(stack[stack.length-2] === stack[stack.length-1]){
               stack.pop();
               stack.pop();
           };
        }
    }
    
    if(stack.length === 0) {
        return 1;
    }else{
        return 0;
    }
}