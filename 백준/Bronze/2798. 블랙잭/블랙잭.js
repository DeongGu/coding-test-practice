const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const N = +input[0].split(" ")[0];
const M = +input[0].split(" ")[1];

const card = input[1].split(" ").map((x) => +x);
const answer = [];

for (let i = 0; i < N; i++) {
  for (let j = i + 1; j < N; j++) {
    for (let k = j + 1; k < N; k++) {
      answer.push(card[i] + card[j] + card[k]);
    }
  }
}

const result = answer.filter((x) => x <= M);
result.sort((a, b) => a - b);
console.log(result[result.length - 1]);
