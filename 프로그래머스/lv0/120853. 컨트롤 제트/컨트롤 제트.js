function solution(s) {
    const arrayS = s.split(" ");
    
    const result = [];
    let answer = 0;
    
    arrayS.map((el,idx) => {
        
        if(el === "Z" ){
            result.pop();
        }else {
            result.push(el);
        }
        
    })
    
    result.map((el) => answer+= +el);
    
    return answer;
}