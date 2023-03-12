function solution(cacheSize, cities) {
    const stack = [];
    let answer = 0;
    
    if(cacheSize === 0) return cities.length * 5;
    
    cities.map((el) => {

        if(stack.length < cacheSize){
            
            if(stack.includes(el.toLowerCase())){
                answer+=1;
                const idx = stack.indexOf(el.toLowerCase());
                stack.splice(idx,1);    
            } else {
                answer+=5;
            }
            stack.push(el.toLowerCase());
            
        }else{
            if(stack.includes(el.toLowerCase())){
              answer+=1;
              const idx = stack.indexOf(el.toLowerCase());
              stack.splice(idx,1);
            }else{
              answer+=5;  
              stack.shift();
            }
            
            stack.push(el.toLowerCase());
            
        }
        
        
    })
    
    return answer;
    
}