function solution(number, limit, power) {
    
    let answer = 0;
    
    const getDivisorCount = (num) => {
        let count = 0;
        for(let i = 1; i*i <= num; i++){
            if(num%i === 0){
                count+=1;
            }
        }
       
        if(Math.floor(Math.sqrt(num))**2 === Math.sqrt(num)**2){
            return (count-1)*2 + 1;    
        }else{
            return count*2;
        }
        
    }
    
    
    for(let i = 1; i <= number; i++){
        if(getDivisorCount(i) > limit){
            answer += power;
        } else{
            answer += getDivisorCount(i);    
        }
    }
    
    
    return answer;
}
