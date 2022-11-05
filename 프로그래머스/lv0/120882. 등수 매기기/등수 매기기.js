function solution(score) {
    const result = [];
    
    for(let i = 0; i < score.length; i++){
        
        let rank = 1;
        
        for(let j = 0; j < score.length; j++){
        
            if((score[i][0] + score[i][1])/2 < (score[j][0] + score[j][1])/2){
                 rank++;
            }
        }
        result.push(rank);         
    }
    
    return result;
}