const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((x) => +x);

const N = input[0];
const arr = [];
for (let i = 1; i < N + 1; i++) {
  arr.push(input[i]);
}

arr.sort((a, b) => a - b);

console.log(arr.join("\n"));
