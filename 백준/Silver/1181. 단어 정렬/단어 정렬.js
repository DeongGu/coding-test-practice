const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const N = +input[0];

input.shift();
input.sort((a, b) => {
  if (a.length === b.length) {
    if (a > b) return 1;
    else if (b > a) return -1;
    else return 0;
  }
  return a.length - b.length;
});
const set = new Set(input);
const result = [...set];
console.log(result.join("\n"));