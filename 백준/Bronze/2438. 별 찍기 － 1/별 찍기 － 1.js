const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim();
let N = +input;
let result = ''
let A = "*";
for(let i = 0; i < N; i++) {
    result += A +"\n"
    A += "*"
}
console.log(result);