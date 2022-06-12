const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const fact = input[0];
const range = input[1];

if (fact.length >= range.length) {
  console.log("go");
} else {
  console.log("no");
}