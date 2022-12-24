const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const count = +input.shift();

for (let i = 0; i < count; i++) {
  input[i] = input[i].split(" ").map(Number);
}

const result = Array.from({ length: count }, () => new Array(count).fill(0));
for (let k = 0; k < 5; k++) {
  for (let i = 0; i < count; i++) {
    for (let j = 0; j < count; j++) {
      if (i !== j && input[i][k] === input[j][k]) {
        result[i][j] += 1;
      }
    }
  }
}

const answer = result.map((el) => el.filter((x) => x !== 0).length);

console.log(answer.indexOf(Math.max(...answer)) + 1);

