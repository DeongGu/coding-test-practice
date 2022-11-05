function solution(A, B) {
    let standard = A+A;
    
    for(let i = 0; i < standard.length; i++){
        
        if(A === B) {
            return 0;
        }else if(B === standard.slice(i, i + A.length)){
            return A.length - i;
        }
    }
    
    return -1;
}