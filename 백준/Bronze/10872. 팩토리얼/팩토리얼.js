const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString();

let N = +input;

function f(n) {
  if (n <= 1) {
    return 1;
  }
  return n * f(n - 1);
}
console.log(f(N));
