const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const answer = [];

for (let i = 0; i < input.length - 1; i++) {
  const result = input[i].replace(/[^aeiou]/gi, "");
  answer.push(result.length);
}

console.log(answer.join("\n"));
