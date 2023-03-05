function solution(food) {
    food.shift();

    let answer = "";
    let playerA = "";
    
    food.map((el,idx) => {
        playerA += String(idx+1).repeat(Math.floor(el/2));
    });
    
    let playerB = playerA.split("").reverse().join("");
    
    answer += playerA + "0" + playerB;
    
    
    return answer;
}