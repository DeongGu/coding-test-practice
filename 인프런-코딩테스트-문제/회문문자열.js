function solution(str) {
  return str.toLowerCase().split("").reverse().join("") === str.toLowerCase()
    ? "YES"
    : "NO";
}

console.log(solution("gooG"));
