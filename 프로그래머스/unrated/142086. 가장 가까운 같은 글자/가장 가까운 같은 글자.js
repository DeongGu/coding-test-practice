function solution(s) {
    const answer = [];
    const objStr = {};
    
    for(let i = 0; i<s.length; i++){
        if(!objStr[s[i]] && objStr[s[i]] !== 0){
            answer.push(-1);
            objStr[s[i]] = i;
        }else{
            answer.push(i - objStr[s[i]]);
            objStr[s[i]] = i;
        }
    }
    
    return answer;
}