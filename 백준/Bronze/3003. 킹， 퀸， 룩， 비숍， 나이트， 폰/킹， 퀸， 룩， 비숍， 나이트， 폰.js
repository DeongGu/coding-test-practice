const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .split(" ")
  .map((x) => +x);

const chess = [1, 1, 2, 2, 2, 8];
const answer = [];
const result = chess.map((x, idx) => answer.push(x - input[idx]));

console.log(answer.join(" "));