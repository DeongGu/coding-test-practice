function solution(num_str) {
   let result = 0;
    
    num_str.split("").forEach(el => result+= +el);
    
    return result;
}