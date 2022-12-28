const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const result = [];
const answer = [];

const length = input[0][0];
const A = input[1];

for (let i = 0; i < length; i++) {
  result.push(A[i] * (i + 1));
}

for (let i = 1; i < length; i++) {
  answer.push(result[i] - result[i - 1]);
}
answer.unshift(result[0]);
console.log(answer.join(" "));