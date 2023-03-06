function solution(k, m, score) {
    
    let answer = 0;
    
    score.sort((a,b) => b-a);
    
    const box = Math.floor(score.length/m);
    
    let count = 0;
    
    for(let i = 0; i < box; i++){
        const Mbox = score.slice(count, count+m);
        answer += Mbox[Mbox.length-1]*m;
        count+= m;
    }
    
    return answer;
}
