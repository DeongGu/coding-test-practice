const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((x) => x.replace(/\r/, ""));

const chars = input[0].split("");
const right = [];
const cmdList = input.slice(2);

cmdList.forEach((cmd) => {
  const [key, char] = cmd.split(" ");
  if (cmd === "L") {
    if (chars.length > 0) right.push(chars.pop());
  }
  if (cmd === "D") {
    if (right.length > 0) chars.push(right.pop());
  }

  if (cmd === "B") chars.pop();
  if (cmd[0] === "P") chars.push(char);
});

console.log(chars.concat(right.reverse()).join(""));
