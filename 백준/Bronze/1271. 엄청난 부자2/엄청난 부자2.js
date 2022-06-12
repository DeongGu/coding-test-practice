const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split(" ").map(BigInt);

const n = input[0];
const m = input[1];

console.log(`${n / m}
${n % m}`);