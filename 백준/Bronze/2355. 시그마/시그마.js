const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map((x) => +x);

const A = input[0];
const B = input[1];

if (A < B) {
  const sum = ((B - A + 1) * (A + B)) / 2;
  console.log(sum);
} else {
  const sum = ((A - B + 1) * (A + B)) / 2;
  console.log(sum);
}
