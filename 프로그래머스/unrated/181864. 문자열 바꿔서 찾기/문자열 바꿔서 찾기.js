function solution(myString, pat) {
    let newStr = "";
    myString.split("").forEach(el => {
        if(el === "A") newStr+= "B";
        else newStr+= "A";
    })    
    
    return newStr.includes(pat) ? 1 : 0;
}