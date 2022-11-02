function solution(babbling) {
    
    const pronunciation = ["aya", "ye", "woo", "ma"];
    
    const result = [];
    
    for(let i = 0; i < babbling.length; i++){
        let str = babbling[i];
        for(let j = 0; j < pronunciation.length; j++ ){
           str = str.replace(pronunciation[j], " ");
        }
        result.push(str);
    }

    const answer = result.filter((x)=> x === ""|| x === " " || x==="  "|| x==="   " || x === "    ");
    return answer.length;
}