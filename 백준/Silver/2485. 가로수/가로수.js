const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

const result = [];
const gcd = (a, b) => (a % b === 0 ? b : gcd(b, a % b));

for (let i = 2; i <= input[0]; i++) {
  result.push(input[i] - input[i - 1]);
}

let gcdNumber = gcd(result[0], result[1]);

for (let i = 0; i < result.length; i++) {
  gcdNumber = gcd(result[i], gcdNumber);
}

let answer = 0;

result.map((el) => (answer += el / gcdNumber));

console.log(answer - input[0] + 1);
