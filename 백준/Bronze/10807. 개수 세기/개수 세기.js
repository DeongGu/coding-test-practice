const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const N = input[1].split(" ");

const result = N.filter((x) => x === input[2]);

console.log(result.length);