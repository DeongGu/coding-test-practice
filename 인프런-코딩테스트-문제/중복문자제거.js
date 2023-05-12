function solution(str) {
  const set = new Set(str);
  const result = [...set].join("");
  return result;
}

console.log(solution("ksekkset"));
