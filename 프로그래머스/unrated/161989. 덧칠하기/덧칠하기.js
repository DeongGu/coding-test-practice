function solution(n, m, section) {
 
   const arr = Array.from({length:n}).fill(0);
   section.map((element) => arr[element-1] = element);
    
    let result = 0;
    
    for(let i = 0; i < section.length; i++){
        
        if(arr.includes(section[i])){
            const index = arr.indexOf(section[i]);
            arr.splice(index,m);
            result++;
        }else{
            continue;
        }
    }
    
    return result;
    
}
