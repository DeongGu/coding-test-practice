const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map((x) => +x);

let N = input[0];
let K = input[1];

let n = 1;
let k = 1;
let subtraction = 1;

for (let i = 1; i <= N; i++) {
  n = n * i;
}
for (let i = 1; i <= K; i++) {
  k = k * i;
}
for (let i = 1; i <= N - K; i++) {
  subtraction = subtraction * i;
}

console.log(n / (k * subtraction));