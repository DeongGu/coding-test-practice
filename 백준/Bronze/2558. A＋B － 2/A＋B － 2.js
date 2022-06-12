const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .split("\n")
  .map((x) => +x);

const A = input[0];
const B = input[1];

console.log(A+B);