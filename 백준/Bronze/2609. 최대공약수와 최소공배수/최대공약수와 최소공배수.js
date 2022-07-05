const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map((x) => +x);

const first = input[0];
const second = input[1];
let GCD = 1;

for (let i = 2; i <= Math.min(first * second); i++) {
  if (first % i === 0 && second % i === 0) {
    GCD = i;
  }
}

const LCM = GCD * (first / GCD) * (second / GCD);

console.log(`${GCD}
${LCM}`);
