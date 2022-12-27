const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

let C = input[0][0];
let R = input[0][1];
const K = input[1][0];

let c_thickness = 0;
let r_thickness = 0;

let stack = 0;
const location = [1, 0];

for (let i = 1; i <= C * R + 2; i++) {
  if (C * R < K) {
    console.log(0);
    return;
  }

  if (
    stack !== K &&
    location[1] < R - r_thickness &&
    location[0] === c_thickness + 1
  ) {
    location[1] += 1;
    stack = i;
    continue;
  }
  if (
    stack !== K &&
    location[1] === R - r_thickness &&
    location[0] < C - c_thickness
  ) {
    location[0] += 1;
    stack = i;
    continue;
  }

  if (
    stack !== K &&
    location[0] === C - c_thickness &&
    location[1] > r_thickness + 1
  ) {
    location[1] -= 1;
    stack = i;
    if (location[1] === r_thickness + 1) {
      c_thickness += 1;
    }
    continue;
  }

  if (
    stack !== K &&
    location[0] > c_thickness + 1 &&
    location[1] === r_thickness + 1
  ) {
    location[0] -= 1;
    stack = i;
    if (location[0] === c_thickness + 1) {
      r_thickness += 1;
    }
    continue;
  }

  if (stack === K) {
    console.log(location.join(" "));
    return;
  }
}
