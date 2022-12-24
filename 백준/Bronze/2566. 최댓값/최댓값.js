const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const result = input.map((el) => Math.max(...el));

const max = Math.max(...result);

const column = result.indexOf(max);

const row = input[column].indexOf(max);

console.log(`${max}
${column + 1} ${row + 1}`);
