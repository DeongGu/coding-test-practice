const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString();
let N = +input;

solution(N);

function check(num){
    const strNum = String(num);
    if(strNum.length<=2){
        return true;
    }
    let d = +strNum[1] - +strNum[0];
    if(+strNum[2] - +strNum[1] === d){
        return true;
    }else {
        return false;
    }
}
function solution(N) {
    let count = 0;
    for(let i = 1; i<=N; i++){
        if(check(i)){
            count++
        }
    }
    console.log(count);
}