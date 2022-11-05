function solution(quiz) {
    const result = [];
    
   const new_quiz = quiz.map((el)=> el.replace("=","==="));
//     new_quiz.map((el)=> eval(el) ? result.push("O"): result.push("X"));
    
//     return result;
    
   new_quiz.map((el) => Function('return '+el)() ? result.push("O"): result.push("X"));
   
    return result;
    
}