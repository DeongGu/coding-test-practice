function solution(n) {
    const result = new Array(n).fill().map(() => new Array(n).fill(0));
    
    let row = 0;
    let col = 0;
    let direct = 0;
    
    for(let i = 1; i <= n*n; i++){
        result[row][col] = i;
        
        if(direct === 0){
            if(col === n-1 || result[row][col+1] !== 0){
                direct = 1;
                row += 1;
                continue;
            }else{
                col+=1;
                continue;
            }
        }
        
        if(direct === 1){
            if(row === n-1 || result[row+1][col] !== 0){
                col -= 1;
                direct = 2;
                continue;
            }else{
                row+=1;
                continue;
            }
        }
        
        if(direct === 2){
            if(col === 0 || result[row][col-1] !== 0){
                direct = 3;
                row -= 1;
                continue;
            }else{
                col -= 1;
                continue;
            }
        }
        
        if(direct === 3){
            if(row === 0 || result[row-1][col] !== 0){
                direct = 0;
                col += 1;
                continue;
            }else{
                row -= 1;
                continue;
            }
        }
        
    }
    return result;
}