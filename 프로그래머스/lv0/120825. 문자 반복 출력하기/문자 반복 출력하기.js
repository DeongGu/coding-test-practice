function solution(my_string, n) {
    let result = "";
    
    my_string.split("").map((el)=> result+= el.repeat(n));
    
    return result;
}