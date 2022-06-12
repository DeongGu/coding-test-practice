const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split(' ');
let A = parseInt(input[0]);
let B = parseInt(input[1]);
console.log(`${A+B}
${A-B}
${A*B}
${Math.floor(A/B)}
${A%B}`);