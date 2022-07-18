const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

for (let i = 0; i < input.length; i++) {
  const [n, s] = input[i].split(" ");

  console.log(Math.floor(Number(s) / (Number(n) + 1)));
}
