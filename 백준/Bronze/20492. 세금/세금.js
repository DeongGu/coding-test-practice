const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString();

const N = +input;

console.log(`${N * 0.78} ${N - N * 0.2 * 0.22}`);
