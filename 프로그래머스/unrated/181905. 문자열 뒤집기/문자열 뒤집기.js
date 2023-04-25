function solution(my_string, s, e) {
    const strArr = my_string.split("");
    
    strArr.splice(s,e-s+1, ...strArr.slice(s,e+1).reverse());
    
    return strArr.join("");
}