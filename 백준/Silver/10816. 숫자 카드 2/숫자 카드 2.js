const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((x) => x.replace("\r", ""));

const N = +input[0];
const M = +input[2];

const card = input[1].split(" ");
const quition = input[3].split(" ");

const result = [];
const obj = {};

card.forEach((el) => (obj[el] ? obj[el]++ : (obj[el] = 1)));

quition.forEach((el) => (obj[el] ? result.push(obj[el]) : result.push(0)));

console.log(result.join(" "));