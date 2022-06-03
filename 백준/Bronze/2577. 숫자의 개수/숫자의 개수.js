const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map((item)=>+item);
let A = input[0];
let B = input[1];
let C = input[2];
let result = [0,0,0,0,0,0,0,0,0,0];

solution(A, B, C);

function solution(A, B, C) {
    let multiple = A*B*C;
    let testCaseArray = String(multiple).split('');
   
    for(let i = 0; i < 10; i++) {
        for(let j = 0; j < testCaseArray.length; j++){
            if(testCaseArray[j] === String(i)) {
                result[i]++
            }
        }
        
    }
}

for(let i = 0; i < 10; i++) {
    console.log(result[i]);
}