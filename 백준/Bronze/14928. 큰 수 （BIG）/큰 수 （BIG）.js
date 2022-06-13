const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString();
const N = BigInt(input);

console.log(`${N % 20000303n}`);