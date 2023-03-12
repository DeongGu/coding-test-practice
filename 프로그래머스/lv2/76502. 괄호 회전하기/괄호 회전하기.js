function solution(s) {
    let answer = 0;
    let limit = 0;
    
    const repeat = (str) => {
        
        if(limit === s.length) return;
        
        const bracket = {"(":0, "{" :0, "[":0};

        for(let i = 0; i < s.length; i++){
            
            if(str[0] === ")" || str[0] === "}" || str[0] === "]") {
                const newStr = str.slice(1) + str[0];
                limit += 1;
                return repeat(newStr);
            }
            
            if(str[i] === "(") bracket["("] += 1;
            if(str[i] === "{") bracket["{"] += 1;
            if(str[i] === "[") bracket["["] += 1;
            
            if(str[i] === ")") {
                bracket["("] -= 1;
                if(bracket["("] < 0 || str[i-1] === "{" || str[i-1] === "["){
                    const newStr = str.slice(1) + str[0];
                    limit += 1;
                    return repeat(newStr);
                }
            }
            
            if(str[i] === "}") {
                bracket["{"] -= 1;
                if(bracket["{"] < 0 || str[i-1] === "(" || str[i-1] === "["){
                    const newStr = str.slice(1) + str[0];
                    limit += 1;
                    return repeat(newStr);
                }
            }
            
            if(str[i] === "]") {
                bracket["["] -= 1;
                if(bracket["["] < 0 || str[i-1] === "(" || str[i-1] === "{"){
                    const newStr = str.slice(1) + str[0];
                    limit += 1;
                    return repeat(newStr);
                }
            }     
        }
        
        if(bracket["("] === 0 && bracket["{"] === 0 && bracket["["] === 0) answer += 1;
        const newStr = str.slice(1) + str[0];
        limit += 1;

        return repeat(newStr);
    }
    
    repeat(s);
    
    return answer;
    
}