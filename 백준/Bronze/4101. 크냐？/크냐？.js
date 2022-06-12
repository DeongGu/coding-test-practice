const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

for (let i = 0; i < input.length - 1; i++) {
  const first = +input[i].split(" ")[0];
  const second = +input[i].split(" ")[1];

  if (first > second) {
    console.log("Yes");
  } else {
    console.log("No");
  }
}