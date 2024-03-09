const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((x) => x.replace(/\r/, ""));

const N = input[0];
const queue = [];
const result = [];

for (let i = 1; i <= N; i++) {
  const [cmd, num] = input[i].split(" ");
  if (cmd === "push") {
    queue.unshift(num);
  }
  if (cmd === "front")
    queue.length === 0 ? result.push(-1) : result.push(queue[queue.length - 1]);
  if (cmd === "pop")
    queue.length === 0 ? result.push(-1) : result.push(queue.pop());
  if (cmd === "size") result.push(queue.length);
  if (cmd === "empty") queue.length === 0 ? result.push(1) : result.push(0);
  if (cmd === "back")
    queue.length === 0 ? result.push(-1) : result.push(queue[0]);
}

console.log(result.join("\n"));