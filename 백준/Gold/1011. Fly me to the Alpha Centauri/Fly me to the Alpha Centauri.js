const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

for (let i = 1; i <= input[0][0]; i++) {
  let x = input[i][0];
  let y = input[i][1];

  if (Math.sqrt(y - x) % 1 === 0) {
    console.log(2 * Math.sqrt(y - x) - 1);
  } else {
    a = Math.pow(Math.ceil(Math.sqrt(y - x)), 2);
    b = Math.pow(Math.ceil(Math.sqrt(y - x)) - 1, 2) + 1;
    if ((a + b) / 2 <= y - x) {
      console.log(2 * Math.ceil(Math.sqrt(y - x)) - 1);
    } else {
      console.log(2 * Math.ceil(Math.sqrt(y - x)) - 2);
    }
  }
}
