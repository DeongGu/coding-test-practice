const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split(" ").map(BigInt);

const A = input[0];
const B = input[1];
const C = input[2];

console.log(`${A + B + C}`);
