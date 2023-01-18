const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const N = +input[0];
input.shift();

const result = [];

for (let i in input) {
  const [num, str] = input[i].split(" ");
  result.push([num, str]);
}

result.sort((a, b) => {
  if (a[0] === b[0]) {
    return a[1].indexOf(a) - b[1].indexOf(b);
  }
  return Number(a[0]) - Number(b[0]);
});
console.log(result.join("\n").replace(/,/g, " "));
