const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');
let count = parseInt(input[0]);
for(let i = 1; i<= count; i++) {
    let A = input[i].split(" ");
    console.log(`${parseInt(A[0]) + parseInt(A[1])}`);
}