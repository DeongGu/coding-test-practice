const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((x) => +x);

let allTime = 0;

input.map((x) => (allTime += x));

console.log(parseInt(allTime / 60) + "\n" + (allTime % 60));