const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim();
let N = +input;
for(let i = 1; i< 10; i++) {
    console.log(`${N} * ${i} = ${N*i}`);
}