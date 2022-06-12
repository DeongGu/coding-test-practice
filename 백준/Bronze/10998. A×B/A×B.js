const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split(' ');
let A = parseInt(input[0]);
let B = parseInt(input[1]);
console.log(A*B);