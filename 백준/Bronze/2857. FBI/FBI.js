const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const index = [];
input.forEach((x, idx) => {
  if (x.includes("FBI") === true) {
    index.push(idx + 1);
  }
});

if (index.length === 0) {
  console.log("HE GOT AWAY!");
} else {
  console.log(index.join(" "));
}
