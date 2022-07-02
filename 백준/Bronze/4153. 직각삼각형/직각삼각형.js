const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

for (let i = 0; i < input.length - 1; i++) {
  const testCase = input[i]
    .split(" ")
    .map((x) => +x)
    .sort((a, b) => a - b);
  const heru = testCase[2];
  const auset = testCase[1];
  const ausar = testCase[0];

  if (heru ** 2 === auset ** 2 + ausar ** 2) {
    console.log("right");
  } else {
    console.log("wrong");
  }
}