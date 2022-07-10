const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

const N = +input;
const star = "*";
const _ = " ";

for (let i = N; i > 0; i--) {
  console.log(_.repeat(N - i) + star.repeat(2 * i - 1));
}
for (let i = 2; i <= N; i++) {
  console.log(_.repeat(N - i) + star.repeat(2 * i - 1));
}
