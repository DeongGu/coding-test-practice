const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

const answer = [];
for (let i = 0; i < input.length / 10; i++) {
  answer.push(input.slice(i * 10, 10 * (i + 1)));
}

console.log(answer.join("\n"));