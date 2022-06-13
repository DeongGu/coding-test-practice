const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const N = +input[0].split(" ")[0];
const M = +input[0].split(" ")[1];

for (let i = 1; i <= N; i++) {
  const arr = input[i].split(" ").map((x) => +x);
  for (let j = 0; j < M; j++) {
    const arr2 = input[i + N].split(" ").map((x) => +x);
    arr[j] += arr2[j];
  }
  console.log(arr.join(" "));
}