const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map((x) => +x);

console.log(
  Math.min(
    Math.abs(input[0] - input[2]),
    Math.abs(input[1] - input[3]),
    Math.abs(0 - input[0]),
    Math.abs(0 - input[1])
  )
);
