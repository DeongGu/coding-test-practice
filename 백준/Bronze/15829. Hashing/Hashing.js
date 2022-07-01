const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const str = {
  a: 1,
  b: 2,
  c: 3,
  d: 4,
  e: 5,
  f: 6,
  g: 7,
  h: 8,
  i: 9,
  j: 10,
  k: 11,
  l: 12,
  m: 13,
  n: 14,
  o: 15,
  p: 16,
  q: 17,
  r: 18,
  s: 19,
  t: 20,
  u: 21,
  v: 22,
  w: 23,
  x: 24,
  y: 25,
  z: 26,
};
const N = +input[0];
const hash = input[1].split("");
let answer = 0;
let r = 1;
for (let i = 0; i < N; i++) {
  answer += str[hash[i]] * r;
  answer %= 1234567891;
  r *= 31;
  r %= 1234567891;
}

console.log(answer);
