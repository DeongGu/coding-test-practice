function solution(n) {
    let result = 0;
    
    if(n%2 !== 0){
        for(let i = 1; i <= (n+1)/2; i++){
            result+= 2*i - 1;
        }
    }else{
        for(let i = 1; 2*i <= n; i++){
            result+= (2*i)**2;
        }
    }
    
    return result;
}