const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split(' ');

const A = BigInt(input[0]);
const B = BigInt(input[1]);

console.log(String(A+B));