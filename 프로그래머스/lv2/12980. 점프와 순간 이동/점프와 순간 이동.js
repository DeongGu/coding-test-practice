function solution(n)
{
    
    let result = 0;
    
    const repeat = (num) => {
        
        if(num === 0) {
            return;
        }
        
        if(num%2 === 0){
            const newN = num/2;
            return repeat(newN);    
        }else{
            const newN = num - 1;
            result+=1;
            return repeat(newN);
        }
        
    }
    
    repeat(n);
    return result;
}