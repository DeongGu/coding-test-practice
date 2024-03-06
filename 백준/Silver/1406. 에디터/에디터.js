const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((x) => x.replace(/\r/, ""));

const chars = input[0].split("");
const N = input[0].length - 1;
const cmdList = input.slice(2);

let current = { prev: N, next: null };

const nodeObj = {};
const createNode = (key, state = true, prev = null, next = null) => ({
  key,
  state,
  prev,
  next,
});

const deleteNode = () => {
  const prev = current.prev;
  const next = current.next;

  if (prev !== null) {
    nodeObj[prev].state = false;
    next !== null ? (nodeObj[next].prev = nodeObj[prev].prev) : null;
    nodeObj[prev].prev !== null
      ? (nodeObj[nodeObj[prev].prev].next = next)
      : null;
    current.prev = nodeObj[prev].prev;
  }
};

const insertNode = (char) => {
  const prev = current.prev;
  const next = current.next;
  const randomNumber = Math.random();
  nodeObj[randomNumber] = createNode(char, true, prev, next);
  current.prev = randomNumber;
  next !== null ? (nodeObj[next].prev = randomNumber) : null;
  prev !== null ? (nodeObj[prev].next = randomNumber) : null;
};

const moveNode = (direction) => {
  const prev = current.prev;
  const next = current.next;

  if (direction === "L") {
    if (prev !== null) {
      current.prev = nodeObj[prev].prev;
      current.next = prev;
    }
  } else {
    if (next !== null) {
      current.prev = next;
      current.next = nodeObj[next].next;
    }
  }
};

chars.forEach((char, idx) => {
  nodeObj[idx] = createNode(char, true, null, null);
  if (idx > 0) {
    nodeObj[idx].prev = idx - 1;
    nodeObj[idx].key = char;
  }
  if (idx < chars.length - 1) {
    nodeObj[idx].next = idx + 1;
    nodeObj[idx].key = char;
  }
});

cmdList.forEach((cmd) => {
  if (cmd === "L" || cmd === "D") {
    moveNode(cmd);
  } else if (cmd === "B") {
    deleteNode();
  } else {
    const [key, char] = cmd.split(" ");
    insertNode(char);
  }
});

let result = "";
for (let key in nodeObj) {
  if (nodeObj[key].state === true && nodeObj[key].prev === null) {
    let currentKey = key;
    while (currentKey !== null) {
      result += nodeObj[currentKey].key;
      currentKey = nodeObj[currentKey].next;
    }
  }
}

console.log(result);