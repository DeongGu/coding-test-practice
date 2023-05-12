function solution(str) {
  if (str.length % 2 === 0) {
    return str.slice(str.length / 2 - 1, str.length / 2 + 1);
  }
  return str[Math.floor(str.length / 2)];
}

console.log(solution("good"));
