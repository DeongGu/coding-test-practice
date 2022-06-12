const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('');

const ABC = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'];

solution(input);

function solution(S) {
    let answer = [-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1];
    
    for(let i =0; i<S.length; i++){
        for(let j = 0; j<ABC.length; j++){
            if(S[i] === ABC[j]){
                if(answer[j] === -1){
                answer[j] = i;                    
                }
            }
        }
    }
    console.log(...answer);
}