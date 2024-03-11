const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((x) => x.replace("\r", ""));

const [N, M] = input[0].split(" ").map(Number);
const board = input.slice(1).map((el) => el.split(""));

let result = Number.MAX_SAFE_INTEGER;

function solution(row, col, bd) {
  let change = 0;
  const check = ["WBWBWBWB", "BWBWBWBW"];
  for (let i = 0; i < 8; i++) {
    let r = row + i;
    for (let j = 0; j < 8; j++) {
      let c = col + j;
      if (bd[r][c] !== check[r % 2][j]) change++;
    }
  }

  return Math.min(change, 64 - change);
}

for (let i = 0; i <= N - 8; i++) {
  for (let j = 0; j <= M - 8; j++) {
    let count = solution(i, j, board);
    if (result > count) result = count;
  }
}

console.log(result);
