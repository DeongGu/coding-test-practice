const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .split(" ")
  .map((x) => +x);

const N = ((input[0] + 1) * (input[1] + 1)) / (input[2] + 1) - 1;

console.log(parseInt(N));
