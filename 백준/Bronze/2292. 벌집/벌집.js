const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim();

solution(+input);

function solution(N){
    let a = 1;
    let count = 1;
    for(let i = 0; i < N; i++){
        if(N > a){
            a = a + 6*count;
            count++
        }else{
            console.log(count);
            break;
        }
    }
}