const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map((x) => +x);

const N = input[0];
const T = input[1];
const C = input[2];
const P = input[3];

if (N % T !== 0) {
  console.log(Math.floor(N / T) * C * P);
} else {
  console.log((Math.floor(N / T) - 1) * C * P);
}
