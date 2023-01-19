const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

for (let j = 1; j < input.length; j++) {
  let m = input[j];
  let cnt = 0;
  function repeatPermutation(sum) {
    if (sum === m) {
      cnt++;
      return;
    }
    for (let i = 1; i <= 3; i++) {
      if (sum + i > m) continue;
      repeatPermutation(sum + i);
    }
  }
  repeatPermutation(0);
  console.log(cnt);
}
