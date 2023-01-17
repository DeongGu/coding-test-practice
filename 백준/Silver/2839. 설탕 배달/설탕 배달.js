const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim();

const N = +input;

if(N%5 === 0) {
    let a = Math.floor(N/5);
    console.log(a);
}else if(N%5 === 1){
    let b = Math.floor(N/5)-1;
    console.log(b+2);
}else if(N === 7 || N === 4){
    console.log(-1);
}else if(N%5 === 2){
    let c = Math.floor(N/5)-2;
    console.log(c+4);
}else if(N%5 === 4){
    let d = Math.floor(N/5)-1;
    console.log(d+3);
}else if(N%5 === 3){
    let e = Math.floor(N/5);
    console.log(e+1);
}else if(N%3 === 0){
    let f = N/3;
    console.log(f);
}else{
    console.log(-1);
}