function solution(my_string) {
    const result = my_string.split("");
    const set = new Set(result);
    
    return [...set].join("");
}