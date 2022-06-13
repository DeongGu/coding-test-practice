const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");
const first = BigInt(input[1]);
const second = BigInt(input[2]);
console.log(`${first * second}`);