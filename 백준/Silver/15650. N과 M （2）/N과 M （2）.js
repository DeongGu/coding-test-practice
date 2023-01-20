const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split(" ");

const N = +input[0];
const M = +input[1];

const visited = new Array(N);
let result = "";
const answer = [];

function repeatPermutation(x, cnt) {
  if (cnt === M) {
    result += `${answer.join(" ")}\n`;
    return;
  }

  for (let i = x; i < N; i++) {
    if (visited[i]) {
      continue;
    }
    visited[i] = true;
    answer.push(i + 1);
    repeatPermutation(i, cnt + 1);
    answer.pop();
    visited[i] = false;
  }
}

repeatPermutation(0, 0);

console.log(result);
