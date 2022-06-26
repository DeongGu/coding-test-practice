const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((x) => +x);

const M = input[1];
const Y = input[0];

const answer = M + (M - Y);

console.log(answer);