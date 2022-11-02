function solution(denum1, num1, denum2, num2) {
    
        let denum = denum1*num2 + denum2*num1;
        let num = num1*num2;
        let max = 1;    
    
        for(let i = 2; i <= denum; i++){
            if(denum%i === 0 && num %i === 0){
                max = i;
            }
        }
        return [denum/max, num/max];
    }
