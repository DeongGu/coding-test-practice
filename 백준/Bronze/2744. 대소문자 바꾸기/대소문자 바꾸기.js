const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

const upper = input.toUpperCase();
const lower = input.toLowerCase();
let answer = "";

for (let i = 0; i < input.length; i++) {
  if (input[i] === upper[i]) {
    answer += input[i].toLowerCase();
  } else {
    answer += input[i].toUpperCase();
  }
}

console.log(answer);