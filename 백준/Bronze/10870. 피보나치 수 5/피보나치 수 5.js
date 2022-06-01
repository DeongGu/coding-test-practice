const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString();

let N = +input;

function f(n) {
  if (n === 0) return 0;
  if (n <= 2) return 1;
  return f(n - 1) + f(n - 2);
}
console.log(f(N));
