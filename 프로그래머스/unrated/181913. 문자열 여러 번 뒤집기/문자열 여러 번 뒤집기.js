function solution(my_string, queries) {
    let str = my_string;
    for(let i = 0; i < queries.length; i++){
        str = str.slice(0,queries[i][0]) + str.slice(queries[i][0],queries[i][1]+1).split("").reverse().join("") + str.slice(queries[i][1]+1); 
    }
    
    return str;
}