function solution(my_string, is_suffix) {
    const result = [];
    for(let i = 1; i <= my_string.length; i++){
        result.push(my_string.slice(my_string.length-i));
    }
    
    return result.includes(is_suffix) ? 1 : 0;
}