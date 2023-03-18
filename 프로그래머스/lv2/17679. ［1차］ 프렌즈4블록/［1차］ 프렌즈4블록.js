function solution(m, n, board) {
    const currentBoard = board.map(el => el.split(""));
    let deleteCount =  0;
    

    
    for(let l = 0; l <= m*n; l++){
    const deleteBlock = [];
 
    for(let i = 0; i < m-1; i++){
        for(let j = 0; j < n-1; j++){
            if(currentBoard[i][j] === "") continue;
            if(currentBoard[i][j] === currentBoard[i][j+1] && currentBoard[i][j] === currentBoard[i+1][j] && currentBoard[i][j] === currentBoard[i+1][j+1]){
                
                deleteBlock.push([i,j]);
            }      
        }  
    }
    
    for(let i = 0; i < deleteBlock.length; i++){
        const x = deleteBlock[i];
        if(currentBoard[x[0]][x[1]] !== "") {
            deleteCount+=1;
            currentBoard[x[0]][x[1]] = "";
        }
        if(currentBoard[x[0]][x[1]+1] !== "") {
            deleteCount+=1;
            currentBoard[x[0]][x[1]+1] = "";
        }
        if(currentBoard[x[0]+1][x[1]] !== "") {
            deleteCount+=1;
            currentBoard[x[0]+1][x[1]] = "";
        }
        if(currentBoard[x[0]+1][x[1]+1] !== "") {
            deleteCount+=1;
            currentBoard[x[0]+1][x[1]+1] = "";
        }
           
    }
    for (let i = 0; i < m - 1; i++) {
            for (let j = 0; j < n; j++) {
                if (currentBoard[i + 1][j] === '') {
                    for (let k = i; k >= 0; k--) {
                        currentBoard[k + 1][j] = currentBoard[k][j];
                        currentBoard[k][j] = '';
                }
            }
        }
    }
    }
    
        
    return deleteCount;
}