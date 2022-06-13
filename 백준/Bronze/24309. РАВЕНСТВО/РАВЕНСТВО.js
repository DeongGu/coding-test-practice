const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n").map(BigInt);

const [a, b, c] = input;

console.log(`${(b - c) / a}`);
