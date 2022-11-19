function solution(lines) {
    
    const start = Math.min(...lines.flat().map((el)=>+el));
    const end = Math.max(...lines.flat().map((el)=> +el));
    
    
    const result = Array(end - start).fill(0);
    
    
    lines.map((arr)=> {
        
        for(let i = arr[0]; i < arr[1]; i++){
            
            if(start <= 0){
                result[i-start]+=1;
            }else{
                
                result[i+1] += 1;
            }
        }
    })
    
    const answer = result.filter((el)=> el > 1);
    
    return answer.length;
        
}


  
