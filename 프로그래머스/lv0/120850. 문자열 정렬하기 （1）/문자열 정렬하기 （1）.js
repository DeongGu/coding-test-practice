function solution(my_string) {
    const new_string = my_string.replace(/[a-z]/gi, "");
    
    
    return [...new_string].map(el=> parseInt(el)).sort((a,b)=> a-b);
}