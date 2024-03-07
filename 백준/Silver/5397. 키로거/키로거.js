const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((x) => x.replace(/\r/, ""));

let result = "";
const N = input[0];
const cmdList = input.slice(1);

for (let i = 0; i < N; i++) {
  let index = 0;
  const cursor = { prev: null, next: null };
  const node = {};

  cmdList[i].split("").forEach((cmd) => {
    const prev = cursor.prev;
    const next = cursor.next;

    if (cmd === "<" && prev !== null) {
      cursor.prev = node[prev].prev;
      cursor.next = prev;
    }

    if (cmd === ">" && next !== null) {
      cursor.prev = next;
      cursor.next = node[next].next;
    }

    if (cmd === "-" && prev !== null) {
      next !== null ? (node[next].prev = node[prev].prev) : null;
      node[prev].prev !== null ? (node[node[prev].prev].next = next) : null;
      cursor.prev = node[prev].prev;
      delete node[prev];
    }

    if (cmd !== ">" && cmd !== "<" && cmd !== "-") {
      node[++index] = { prev: prev, next: next, char: cmd };
      cursor.prev = index;
      next !== null ? (node[next].prev = index) : null;
      prev !== null ? (node[prev].next = index) : null;
    }
  });

  for (let key in node) {
    if (node[key].prev === null) {
      let currentKey = key;
      while (currentKey !== null) {
        result += node[currentKey].char;
        currentKey = node[currentKey].next;
      }
    }
  }

  if (i !== N - 1) result += "\n";
}

console.log(result);