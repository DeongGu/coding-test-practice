function solution(my_string) {
    const answer = my_string.split("").map((el) => el===el.toUpperCase()? el.toLowerCase() : el.toUpperCase());
    
    return answer.join("");
}