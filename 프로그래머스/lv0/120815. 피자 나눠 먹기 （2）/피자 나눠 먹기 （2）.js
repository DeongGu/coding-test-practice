function solution(n) {
   return n/gcf(n,6);
}

function gcf(a,b){
    return a%b === 0 ? b : gcf(b,a%b);
}