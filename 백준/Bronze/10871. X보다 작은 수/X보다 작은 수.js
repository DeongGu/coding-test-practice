const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let [N ,X] = input[0].split(' ').map((item) => +item);
let A = input[1].split(' ').map((item) => +item);

solution(N,X,A);

function solution(N,X,A) {
    const result = [];
    for(let i = 0; i < N; i++) {
        if(A[i] < X) {
            result.push(A[i]); 
        }
    }
    console.log(result.join(' '));
}