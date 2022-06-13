const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .split("\n")
  .map((x) => +x)
  .sort((a, b) => a - b);

const result = [];
for (let i = 1; i <= 30; i++) {
  result.push(i);
}

const answer = result.filter((x) => !input.includes(x));

console.log(answer.join("\n"));
