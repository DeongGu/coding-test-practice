const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

let word = "";
for (let i = 0; i < input.length; i++) {
  word = input[i] + word;
}

console.log(word);