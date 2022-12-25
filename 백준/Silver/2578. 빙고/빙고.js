const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const board = input.slice(0, 5);
const bingoNumber = input.slice(5, 10);

let bingo = 0;
let first = 0;
let second = 0;

const getRowBingo = (arr, el) => arr.reduce((ac, v) => ac + (v === el), 0);

for (let i = 0; i < 5; i++) {
  for (let j = 0; j < 5; j++) {
    for (let k = 0; k < 5; k++) {
      for (let l = 0; l < 5; l++) {
        if (board[k][l] === bingoNumber[i][j]) {
          board[k][l] = 0;

          if (getRowBingo(board[k], 0) === 5) {
            bingo++;
          }

          if (
            board[0][l] === 0 &&
            board[1][l] === 0 &&
            board[2][l] === 0 &&
            board[3][l] === 0 &&
            board[4][l] === 0
          ) {
            bingo++;
          }

          if (
            board[0][0] === 0 &&
            board[1][1] === 0 &&
            board[2][2] === 0 &&
            board[3][3] === 0 &&
            board[4][4] === 0
          ) {
            if (first === 0 || first !== 1) {
              bingo++;
              first++;
            }
          }

          if (
            board[0][4] === 0 &&
            board[1][3] === 0 &&
            board[2][2] === 0 &&
            board[3][1] === 0 &&
            board[4][0] === 0
          ) {
            if (second === 0 || second !== 1) {
              bingo++;
              second++;
            }
          }

          if (bingo >= 3) {
            console.log(i * 5 + j + 1);
            return;
          }

          break;
        }
      }
    }
  }
}
