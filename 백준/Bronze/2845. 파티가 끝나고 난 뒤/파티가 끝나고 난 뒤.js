const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const L = +input[0].split(" ")[0];
const P = +input[0].split(" ")[1];

const answer = input[1].split(" ").map((x) => +x - L * P);

console.log(answer.join(" "));