function solution(my_string, m, c) {
    let result = "";
    
    for(let i = 0; i <= my_string.length-m; i+=m){
        const str = my_string.slice(i,i+m);
        result+= str[c-1];                             
    }
    
    return result;
}