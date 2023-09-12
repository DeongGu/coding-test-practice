function solution(triangle) {
    const n = triangle.length;
    const memo = Array.from({length: triangle.length}, (_,idx) => new Array(idx+1).fill(0));
    memo[0][0] = triangle[0][0];
    
    for(let i = 1; i < n; i++){
        
        for(let j = 0; j < triangle[i].length; j++){
            
            if(j === 0) {
                memo[i][j] = memo[i-1][j] + triangle[i][j];
                continue;
            }
            if(j === triangle[i].length-1){
                memo[i][j] = memo[i-1][j-1] + triangle[i][j]; 
                continue;
            }
             
            memo[i][j] = Math.max(memo[i-1][j-1], memo[i-1][j]) + triangle[i][j];
            
        }
            
    }
    
    return Math.max(...memo[memo.length-1]);
}