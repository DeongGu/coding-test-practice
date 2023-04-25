function solution(number) {
    let newNum = 0;
    
    number.split("").forEach((el) => newNum+= Number(el));
    
    return newNum % 9;
}