const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split(" ");

const N = input[0];
const B = input[1];

const answer = Number.parseInt(N, B);

console.log(answer);