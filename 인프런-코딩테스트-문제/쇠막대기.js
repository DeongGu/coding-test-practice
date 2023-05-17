function solution(str) {
  let result = 0;
  const stack = [];

  for (let i = 0; i < str.length; i++) {
    if (str[i] === "(") {
      stack.push(str[i]);
    } else {
      stack.pop();
      if (str[i - 1] === "(") {
        result += stack.length;
      } else {
        result++;
      }
    }
  }
  return result;
}

console.log(solution("()(((()())(())()))(())"));
console.log(solution("(((()(()()))(())()))(()())"));
