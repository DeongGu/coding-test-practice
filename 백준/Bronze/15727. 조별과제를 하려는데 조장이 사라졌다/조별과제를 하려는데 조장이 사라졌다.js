const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

const L = +input;
let t = 0;
while (t * 5 < L) {
  t += 1;
}

console.log(t);