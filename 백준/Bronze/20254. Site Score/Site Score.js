const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .split(" ")
  .map((x) => +x);

const UR = 56 * input[0];
const TR = 24 * input[1];
const UO = 14 * input[2];
const TO = 6 * input[3];

console.log(UR + TR + UO + TO);