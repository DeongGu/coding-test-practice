const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");
const lightChainK = +input[0].split(" ")[0] * +input[0].split(" ")[1];
const lightChainL = +input[1].split(" ")[0] * +input[1].split(" ")[1];
const heavyChain =
  +input[2].split(" ")[0] * +input[2].split(" ")[1] * +input[2].split(" ")[2];

console.log((lightChainK + lightChainL) * heavyChain);
