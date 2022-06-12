let fs = require("fs")
let input = fs.readFileSync("dev/stdin").toString().trim();
let N = ''
for(let i = 1; i <= input; i++) {
    N += i +"\n";
}
console.log(N);