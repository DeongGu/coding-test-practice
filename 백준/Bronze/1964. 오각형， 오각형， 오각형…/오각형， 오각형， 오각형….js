const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

const N = +input;
const answer = (3 * N * (N - 1)) / 2 + 4 * N + 1;
console.log(answer % 45678);