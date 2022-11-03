function solution(my_string, letter) {
    const result = my_string.split("").filter((el)=> el !== letter).join("");
    
    return result;
}