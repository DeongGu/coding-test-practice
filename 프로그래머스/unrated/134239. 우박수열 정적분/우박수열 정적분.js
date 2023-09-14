function solution(k, ranges) {
    const heights = [k];
    const area = [];
    const result = [];
    
    let newK = k;
    
    while(newK > 1){
        if(newK % 2 !== 0){
            newK = newK*3 +1;
            heights.push(newK);
        }
        
        if(newK % 2 === 0){
            newK = newK/2;
            heights.push(newK);
        }
    }
    
    for(let i = 0; i < heights.length-1; i++){
        area.push((heights[i]+ heights[i+1])/2);
    }
    
    for(const [start, end] of ranges){
        let sum = 0;
        
        if(start <= end + heights.length-1){
            for(let i = start; i < end+heights.length-1; i++){
                sum+= area[i];
            }
            result.push(sum);    
        }else{
            result.push(-1);
        }
        
    }
    
    return result;
    
}