const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const scorePoint = [6, 3, 2, 1, 2];

const first = input[0].split(" ");
const second = input[1].split(" ");

let firstScore = 0;
let secondScore = 0;

for (let i = 0; i < scorePoint.length; i++) {
  firstScore += first[i] * scorePoint[i];
  secondScore += second[i] * scorePoint[i];
}

console.log(firstScore, secondScore);