function solution(myString, pat) {
    const newStr = myString.toLowerCase();
    const newPat = pat.toLowerCase();
    
    return newStr.includes(newPat) ? 1 : 0;
}