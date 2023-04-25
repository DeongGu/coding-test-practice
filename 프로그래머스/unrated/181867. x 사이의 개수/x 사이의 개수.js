function solution(myString) {
    const result = [];
    const newStr = myString.split("x");
    
    newStr.forEach((el) => result.push(el.length));
    
    return result;
}