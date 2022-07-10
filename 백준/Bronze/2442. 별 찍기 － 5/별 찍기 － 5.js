const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

const N = +input;
let star = "*";
let _ = " ";

for (let i = 0; i < N; i++) {
  console.log(_.repeat(N - i - 1) + star.repeat(2 * i + 1));
}
