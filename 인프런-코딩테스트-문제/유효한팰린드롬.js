function solution(str) {
  const newStr = str.replace(/[^a-zA-Z]/g, "").toLowerCase();
  return newStr.split("").reverse().join("") === newStr ? "YES" : "NO";
}

console.log(solution("found7, time: study; Yduts; emit, 7Dnuof"));
