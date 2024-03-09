const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((x) => x.replace(/\r/, ""));

const N = input[0];
const deque = [];
const result = [];

for (let i = 1; i <= N; i++) {
  const [cmd, num] = input[i].split(" ");
  if (cmd === "push_front") {
    deque.unshift(num);
  }
  if (cmd === "push_back") {
    deque.push(num);
  }

  if (cmd === "pop_front")
    deque.length === 0 ? result.push(-1) : result.push(deque.shift());
  if (cmd === "pop_back")
    deque.length === 0 ? result.push(-1) : result.push(deque.pop());

  if (cmd === "front")
    deque.length === 0 ? result.push(-1) : result.push(deque[0]);
  if (cmd === "back")
    deque.length === 0 ? result.push(-1) : result.push(deque[deque.length - 1]);

  if (cmd === "size") result.push(deque.length);
  if (cmd === "empty") deque.length === 0 ? result.push(1) : result.push(0);
}

console.log(result.join("\n"));
