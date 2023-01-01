const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .split("")
  .map((x) => +x);

let sum = 0;
for (let i = 0; i < input.length; i++) {
  sum += input[i] ** 5;
}

console.log(sum);