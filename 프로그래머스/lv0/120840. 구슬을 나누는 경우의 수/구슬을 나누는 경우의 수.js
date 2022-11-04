function solution(balls, share) {
    let top = 1;
    let bottom = 1;
    
    for(let i = 0; i < share; i++){
        top *= balls - i;
    }
    
    for(let j = 0; j < share; j++){
        bottom *= share - j;
    }
    
    return Math.floor(top/bottom);
}