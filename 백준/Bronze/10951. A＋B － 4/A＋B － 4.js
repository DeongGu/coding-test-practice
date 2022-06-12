const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
for(let i = 0; i < input.length; i++){
    let test = input[i].split(' ').map((item)=>+item);
    console.log(test[0] + test[1]);
}