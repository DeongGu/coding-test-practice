function solution(q, r, code) {
    let result = "";
    
    code.split("").forEach((_,idx) => {
        if(idx%q === r){
            result+= code[idx];
        }
    })
    
    return result;
}