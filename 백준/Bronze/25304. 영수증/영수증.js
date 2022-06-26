const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const X = +input[0];
const N = +input[1];
let sum = 0;

for (let i = 2; i < N + 2; i++) {
  const buy = input[i].split(" ").map((x) => +x);
  const a = buy[0];
  const b = buy[1];
  sum += a * b;
}

if (sum === X) {
  console.log("Yes");
} else {
  console.log("No");
}