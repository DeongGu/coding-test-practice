function solution(my_string, is_prefix) {
    const result = [];
    
    my_string.split("").forEach((_,idx) => result.push(my_string.slice(0,idx)));
    
    return result.includes(is_prefix) ? 1 : 0;
}