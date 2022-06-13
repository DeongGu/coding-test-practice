const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split(" ");

const M = input[1];
const K = input[2];

console.log(parseInt(K / M), K % M);