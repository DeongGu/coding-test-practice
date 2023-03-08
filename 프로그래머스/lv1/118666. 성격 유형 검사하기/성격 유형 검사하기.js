function solution(survey, choices) {
    const pType = {R:0, T:0, C:0, F:0, J:0, M:0, A:0, N:0};
    let answer = "";
    
    survey.map((el,idx) => {
        const str = el.split("");
        if(choices[idx] < 4){
            pType[str[0]] += -choices[idx] + 4;
        } else {
            pType[str[1]] += choices[idx] - 4;
        }
    });
    
    if(pType.R >= pType.T){
        answer+= "R";
    } else {
        answer+= "T";
    }
    if(pType.C >= pType.F){
        answer+= "C";
    } else {
        answer+= "F";
    }
    if(pType.J >= pType.M){
        answer+= "J";
    } else {
        answer+= "M";
    }
    if(pType.A >= pType.N){
        answer+= "A";
    } else {
        answer+= "N";
    }
    
    return answer;
}