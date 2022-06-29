const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const time = input[0].split(" ");
let hour = +time[0];
let min = +time[1];
let sec = +time[2];

const D = +input[1];

let sum = hour * 60 * 60 + min * 60 + sec + D;

hour = Math.floor(sum / 3600);
min = Math.floor((sum % 3600) / 60);
sec = sum - hour * 3600 - min * 60;

hour = hour % 24;
console.log(hour, min, sec);