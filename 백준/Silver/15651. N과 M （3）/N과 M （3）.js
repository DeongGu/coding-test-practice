const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split(" ");

const N = input[0];
const M = input[1];

let result = "";
const answer = [];

function repeatPermutation(x) {
  if (x == M) {
    result += `${answer.join(" ")}\n`;
    return;
  }

  for (let i = 0; i < N; i++) {
    answer.push(i + 1);
    repeatPermutation(answer.length);
    answer.pop();
  }
}

repeatPermutation(0);

console.log(result.trim());
