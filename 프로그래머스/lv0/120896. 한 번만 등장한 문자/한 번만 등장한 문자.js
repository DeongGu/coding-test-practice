function solution(s) {
    const result = {};
    const answer = [];
    
    s.split("").map((el) => result[el] ? result[el]++ : result[el]=1);
    
    const values = Object.values(result);
    const keys = Object.keys(result);
    const idx = [];
    
    for(let i = 0; i < values.length; i++){
        
        if(values[i] === 1){
            idx.push(values.indexOf(1));
            values[i] = 0;
        }
    }
    
    for(let j = 0; j < idx.length; j++){
        
        answer.push(keys[idx[j]]);
    }
    
    return answer.sort().join("");
}