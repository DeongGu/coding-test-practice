function solution(my_string, indices) {
    const arr = my_string.split("");
    indices.forEach((el) => {
        arr.splice(el,1,"");
    });
    
    return arr.join("");
}