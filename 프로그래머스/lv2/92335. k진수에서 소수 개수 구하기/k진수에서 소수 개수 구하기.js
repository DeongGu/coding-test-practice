function solution(n, k) {
    
    let answer = 0;
    
    const newN = n.toString(k).split("0").map(Number);
    
    
    for(let i = 0; i < newN.length; i++){
        
        if(newN[i] === 1 || newN[i] === 0) {
            answer+=1;
            continue;
        };
        
        for(let j = 2; j*j <= newN[i]; j++){
            
            if(newN[i]%j === 0){
                answer+=1;
                break;
            }
        }
    }
    return newN.length - answer;
}