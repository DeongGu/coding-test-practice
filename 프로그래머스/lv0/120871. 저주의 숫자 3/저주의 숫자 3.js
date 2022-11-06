function solution(n) {
    const result = {};
    let num = 1;
    for(let i = 1; i <= 100; i++){
        
       
        
        if(num%3 === 0 || num.toString().split("").includes("3")){
            num++;
            if(num%3 === 0 || num.toString().split("").includes("3")){
                num++;
                if(num%3 === 0 || num.toString().split("").includes("3")){
                     num++;
                    if(num%3 === 0 || num.toString().split("").includes("3")){
                        num++;
                        if(num%3 === 0 || num.toString().split("").includes("3")){
                            num++;
                        }
                    }
                }
            }
        }
        
         result[i] = num;  
        
        num++;
        if(num%3 === 0 || num.toString().split("").includes("3")){
            num++;
            if(num%3 === 0 || num.toString().split("").includes("3")){
                num++;
                if(num%3 === 0 || num.toString().split("").includes("3")){
                     num++;
                    if(num%3 === 0 || num.toString().split("").includes("3")){
                        num++;
                        if(num%3 === 0 || num.toString().split("").includes("3")){
                            num++;
                            if(num%3 === 0 || num.toString().split("").includes("3")){
                                num++;
                             }
                        }
                    }
                }
            }
        }
    }
    
    return result[n];
}