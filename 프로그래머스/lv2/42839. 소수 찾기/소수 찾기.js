function solution(numbers) {
    const numbersArr = numbers.split("").sort((a,b) => b - a);
   
    const primesArr = Array(parseInt(numbersArr.join(""))+1).fill(true).fill(false, 0,2);
    
     for(let i = 2 ; i * i <= parseInt(numbersArr.join("")); i++){
        if(primesArr[i]){
            for(let j = i * i; j <= parseInt(numbersArr.join("")); j+=i){
                primesArr[j] = false;
            }
        }
    }
    
    let primes = primesArr.map((el, idx) => el ? idx : 0).filter(el => el).map(String);
    
    for(let i = 0; i < numbersArr.length; i++){
       primes = primes.map(el => el.replace(numbersArr[i],"")); 
    }
    
    return primes.filter((el) => el ==="").length;
}