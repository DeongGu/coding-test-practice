const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map((x) => +x);

const R1 = input[0];
const S = input[1];

const R2 = 2 * S - R1;

console.log(R2);