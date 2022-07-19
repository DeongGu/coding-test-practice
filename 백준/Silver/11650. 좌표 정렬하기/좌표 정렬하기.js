const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const N = +input[0];
input.shift();

const result = [];

for (let i of input) {
  let [a, b] = i.split(" ");
  result.push([a, b]);
}
result.sort((a, b) => {
  if (a[0] !== b[0]) {
    return a[0] - b[0];
  }
  return a[1] - b[1];
});

console.log(result.join("\n").replace(/\,/g, " "));
