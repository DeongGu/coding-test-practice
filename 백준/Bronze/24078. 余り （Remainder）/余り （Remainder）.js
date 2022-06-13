const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString();

const x = +input;

console.log(x % 21);