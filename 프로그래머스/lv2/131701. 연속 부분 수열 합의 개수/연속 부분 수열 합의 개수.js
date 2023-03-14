function solution(elements) {
    const newElements = [...elements,...elements];
    const result = [];
    
    for(let i =0; i < elements.length; i++){
    
        for(let j = 0; j < elements.length; j++){
            const stack = [];
            stack.push(...newElements.slice(j,j+i));
            result.push(stack.reduce((a,c) => parseInt(a)+parseInt(c), 0));
        }
        
    }
    
    const set  = new Set(result);
    const answer = [...set];
    
    return answer.length;
}