function solution(babbling) {
    
    const newbabbling = [];
    
    for(let i = 0; i < babbling.length; i++){
        if(babbling[i].includes("ayaaya")) babbling.splice(i,1,"x");
        if(babbling[i].includes("yeye")) babbling.splice(i,1,"x");
        if(babbling[i].includes("woowoo")) babbling.splice(i,1,"x");
        if(babbling[i].includes("mama")) babbling.splice(i,1,"x");
    }
    
    for(let i = 0; i < babbling.length; i++){
        newbabbling.push(babbling[i].replace(/(aya|ye|woo|ma)/g, ""));
    }
    
    const answer = newbabbling.filter((el) => el ==="");
    
    return answer.length;
}