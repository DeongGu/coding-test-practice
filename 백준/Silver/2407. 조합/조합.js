const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

let n = input[0];
let m = input[1];

let top = 1;
let bottom = 1;

if (m >= n / 2) {
  m = n - m;
}

for (let i = 0; i < m; i++) {
  top = BigInt(top) * BigInt(n - i);
}
for (let i = 1; i <= m; i++) {
  bottom = BigInt(bottom) * BigInt(i);
}

console.log(`${BigInt(top) / BigInt(bottom)}`);
