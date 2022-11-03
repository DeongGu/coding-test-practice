function solution(my_string, num1, num2) {
    const first = my_string[num1];
    const second = my_string[num2];
    const result = my_string.split("");
    result.splice(num1,1, second);
    result.splice(num2,1, first);
    
    return result.join("");
}