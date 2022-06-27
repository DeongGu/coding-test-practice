const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((x) => +x);

const A = input[0];
const B = input[1];
const C = input[2];
const D = input[3];
const P = input[4];

let X = P * A;
let Y = 0;

if (P <= C) {
  Y = B;
} else {
  Y = B + D * (P - C);
}

if (X > Y) {
  console.log(Y);
} else {
  console.log(X);
}