const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

solution(input);

function solution(input) {
    let testArray = input[1].trim().split(' ').map((item)=>+item);
    let M = Math.max(...testArray);
    let N = +input[0];
    let numberArray = testArray.map((item)=>item/M*100);
    let sum = 0;
    for(let i = 0; i<N; i++){
        sum+=numberArray[i];
    }
    let result = sum/N
    console.log(result);
}