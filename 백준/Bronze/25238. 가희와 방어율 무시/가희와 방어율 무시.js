const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .split(" ")
  .map((x) => +x);

const a = input[0];
const b = input[1];

if (a * ((100 - b) / 100) >= 100) {
  console.log(0);
} else {
  console.log(1);
}
