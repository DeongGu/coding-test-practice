const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

console.log(`${(+input + 1) * 2} ${(+input + 1) * 3}`);
