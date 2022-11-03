function solution(my_string) {
    const regExp = /[a-z]/gi;
    const new_string = my_string.replace(regExp,"");
    
    let result = 0;
    
    new_string.split("").map((el)=> result+= parseInt(el));
    
    return result;
}