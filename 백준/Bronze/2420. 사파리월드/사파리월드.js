const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map(BigInt);

const N = input[0];
const M = input[1];

if (N - M > 0) {
  console.log(`${N - M}`);
} else {
  console.log(`${M - N}`);
}