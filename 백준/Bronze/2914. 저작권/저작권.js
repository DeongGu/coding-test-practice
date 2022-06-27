const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map((x) => +x);

const A = input[0];
const I = input[1];

console.log(A * (I - 1) + 1);