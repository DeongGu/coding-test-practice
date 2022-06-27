const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

const n = +input;

console.log(4 * n);