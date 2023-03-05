function solution(X, Y) {
    const objX = {};
    const objY = {};
    let answer = "";
    
    for(let i = 0; i < X.length; i++){
        if(objX[X[i]]){
            objX[X[i]] += 1;
        }else{
            objX[X[i]] = 1;
        }    
    }
    
    for(let i = 0; i < Y.length; i++){
        if(objY[Y[i]]){
            objY[Y[i]] += 1;
        }else{
            objY[Y[i]] = 1;
        }    
    }
    
    for(let i = 9; i >= 0; i--){
        if(objX[i] && objY[i]){
            if(objX[i] < objY[i]){
                answer += String(i).repeat(objX[i]);
            } else{
                answer += String(i).repeat(objY[i]);
            }
        }
    }
    
    if(answer.length === 0) return "-1";
    if(answer[0] === "0") return "0";
    return answer;
    
}