const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .split(" ")
  .map((x) => +x);

let sum = 0;

input.map((x) => (sum += x * 5));

console.log(sum);
