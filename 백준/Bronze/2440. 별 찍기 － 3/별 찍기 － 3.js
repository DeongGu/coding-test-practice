const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

const N = +input;
const answer = [];
let star = "*";
for (let i = 0; i < N; i++) {
  answer.push(star);
  star += "*";
}

console.log(answer.reverse().join("\n"));