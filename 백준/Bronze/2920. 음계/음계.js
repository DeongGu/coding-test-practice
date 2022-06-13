const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .split(" ")
  .map((x) => +x);

const ascending = [1, 2, 3, 4, 5, 6, 7, 8];
const descending = [8, 7, 6, 5, 4, 3, 2, 1];
let asc = 0;
let des = 0;

for (let i = 0; i < input.length; i++) {
  if (input[i] === ascending[i]) {
    asc++;
  } else if (input[i] === descending[i]) {
    des++;
  }
}

if (asc === 8) {
  console.log("ascending");
} else if (des === 8) {
  console.log("descending");
} else {
  console.log("mixed");
}