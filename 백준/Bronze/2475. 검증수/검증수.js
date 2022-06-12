const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map((x) => +x);

let answer = 0;

for (let i = 0; i < input.length; i++) {
  answer += input[i] ** 2;
}

console.log(answer % 10);