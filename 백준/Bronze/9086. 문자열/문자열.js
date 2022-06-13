const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const T = +input[0];

for (let i = 1; i <= T; i++) {
  let word = input[i].replace(/\r/g, "");
  console.log(word[0] + word[word.length - 1]);
}
