function solution(n) {
    let result = 0;
    String(n).split("").map((el)=> result += parseInt(el));
    
    return result;
}