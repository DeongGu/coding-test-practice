function solution(a, b) {
    function gcd(a,b) {
        return a%b === 0 ? b : gcd(b, a%b); 
    }
    
    let newA = a/gcd(a,b);
    let newB = b/gcd(a,b);
    
    
    while(newB > 1){
        
        if(newB % 2 === 0){
            newB = newB/2;
        }else if(newB % 5 === 0){
            newB = newB/5;
        }else {
            return 2;
        }
    }
    
    return 1;
              
}