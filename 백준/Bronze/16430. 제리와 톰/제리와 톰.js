const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .split(" ")
  .map((x) => +x);

console.log(`${input[1] - input[0]} ${input[1]}`);
