const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();
const N = +input;

const count = N / 4;
const LONG = "long";
const INT = "int";
const result = [];

for (let i = 0; i < count; i++) {
  result.push(LONG);
}

result.push(INT);

console.log(result.join(" "));