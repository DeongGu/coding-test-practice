function solution(rows, columns, queries) {
    
    const arr = Array.from({length:rows}, (_,idx) => Array.from({length:columns}, (_, index) => idx*columns+index+1 ));
  
    let tmp = [];
    const result = [];
    
    for(const [x1,y1,x2,y2] of queries){
        let count = 0;
        
        for(let i = y1 - 1; i < y2; i++){
            tmp.push(arr[x1-1][i]);
        }
        
        for(let i = x1; i < x2; i++){
            tmp.push(arr[i][y2-1]);
        }
        
        for(let i = y2 - 2; i > y1 - 2; i--){
            tmp.push(arr[x2-1][i]);
        }
        
        for(let i = x2 - 2; i > x1 - 1; i--){
            tmp.push(arr[i][y1-1]);
        }
        
        result.push(Math.min(...tmp));
        
        
        for(let i = y1; i < y2; i++){
            arr[x1-1][i] = tmp[count];
            count++;
        }
        
        for(let i = x1; i < x2; i++){
            arr[i][y2 - 1] = tmp[count];
            count++;
        }
        
        for(let i = y2 - 2; i > y1 - 2; i--){
            arr[x2-1][i] = tmp[count];
            count++;
        }
        
        for(let i = x2 - 2; i >= x1 - 1; i--){
            arr[i][y1-1] = tmp[count];
            count++;
        }
        
        tmp = [];
    }
    
    return result;
}
    