const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const T = +input[0];

input.shift();

for (let i = 0; i < T; i++) {
  let str = input[i].replace("\r", "");
  let result = "YES";
  let count = [];

  for (let j = 0; j < str.length; j++) {
    if (str[j] === "(") {
      count.push(1);
    } else if (!count.pop()) {
      result = "NO";
      break;
    }
  }
  if (count.length !== 0) {
    result = "NO";
  }
  console.log(result);
}
