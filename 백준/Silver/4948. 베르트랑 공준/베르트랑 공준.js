const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((x) => +x);

const n = input;
const answer = [];

for (let i = 0; i < n.length - 1; i++) {
  let count = 0;
  for (let j = n[i] + 1; j <= 2 * n[i]; j++) {
    for (let k = 2; k * k <= 2 * n[i]; k++) {
      if (j % k === 0) {
        count++;
        break;
      }
    }
  }
  let result = n[i] - count;

  answer.push(result);
}
console.log(answer.join("\n"));