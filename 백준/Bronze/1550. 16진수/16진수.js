const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

const answer = Number.parseInt(input, 16);
console.log(answer);