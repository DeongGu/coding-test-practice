function solution(places) {
    const answer = [];
    
    function check(board){
    
    function OOB(a,b){
        return a < 0 || a > 4 || b < 0 || b > 4;
    }
    
    const dx1 = [1, 0, -1, 0];
    const dy1 = [0, 1, 0, -1];
    
    const dx2 = [1,-1, 1,-1];
    const dy2 = [1,1, -1,-1];
    
     const dx3 = [2, 0, -2, 0];
    const dy3 = [0, 2, 0, -2];
    
    for(let i = 0; i < 5; i++){
        for(let j = 0; j < 5; j++){
            if(board[i][j] !== "P") continue;
            for(let k = 0; k < 4; k++){
                const nx = i+dx1[k];
                const ny = j+dy1[k];
                if(!OOB(nx,ny) && board[nx][ny] === "P") return 0;
            }
            
            for(let k = 0; k < 4; k++){
                const nx = i+dx2[k];
                const ny = j+dy2[k];
                if(!OOB(nx,ny) && board[nx][ny] === "P"){
                    if(board[i][ny] !== "X" || board[nx][j] !== "X") return 0;
                }
            }
            
            for(let k = 0; k < 4; k++){
                const nx = i+dx3[k];
                const ny = j+dy3[k];
                if(!OOB(nx,ny) && board[nx][ny] === "P"){
                    if(board[i+dx1[k]][j+dy1[k]] !== "X") return 0;
                }
            }
        }
    }
    return 1;
    
}
    
    for(let i = 0; i < 5; i++){
        answer.push(check(places[i]));
    }
    
   
    
    return answer;
}