const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const a = input[0].split(" ").map((x) => +x);
const c = input[1].split(" ").map((x) => +x);
const b = [];

b[2] = c[2] - a[0];
b[1] = c[1] / a[1];
b[0] = c[0] - a[2];

console.log(b.join(" "));