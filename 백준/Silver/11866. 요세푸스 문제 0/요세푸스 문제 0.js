const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

const [N, K] = input.split(" ").map(Number);

const result = [];
const checkArr = Array.from({ length: N }).map((_, idx) => idx + 1);

while (checkArr.length !== 0) {
  for (let i = 0; i < K; i++) {
    if (i === K - 1) {
      result.push(checkArr.shift());
    } else {
      checkArr.push(checkArr.shift());
    }
  }
}

console.log(`<${result.join(", ")}>`);
