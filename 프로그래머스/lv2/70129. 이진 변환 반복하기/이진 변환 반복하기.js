function solution(s) {
    const result = [0,0];
    
    const delZero = (newS) => {
        
        if(newS === "1") return;
        const firstStep = newS.replace(/0/g, "");
        
        result[0] += 1;
        result[1] += newS.length - firstStep.length;
        
        const secondStep = (firstStep.length).toString(2);
        
        return delZero(secondStep);
    }
    
    delZero(s);
    
    return result;
    
}