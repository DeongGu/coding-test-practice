function solution(n) {

    const result = [];

    while(n/3 !== 0){
        if(n%3 === 0){
            result.push(4);
            n = Math.floor(n/3)-1;
        }else{
            result.push(n%3);
            n = Math.floor(n/3);
        }
        
       
    }
    
    return result.reverse().join("");
}