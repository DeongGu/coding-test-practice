const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .split("\n")
  .map((x) => +x);

const regular = input[0];
const small = input[1];

const total = regular * 8 + small * 3;

console.log(total - 28);
