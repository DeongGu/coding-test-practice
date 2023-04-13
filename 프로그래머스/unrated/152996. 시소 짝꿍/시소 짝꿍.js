function solution(weights){
    let obj = {};
    let result = 0;
    
    weights.forEach((el) => {
        if(obj[el]){
            result+=obj[el];
            obj[el]++;
        }else{
            obj[el] = 1;
        }
    });
    
    const check = {};
    const noSame = Object.keys(obj);
    
    for(let i = 2; i <= 4; i++){
        noSame.forEach((el) => {
            const distance = el*i;
            
            if(check[distance]){
                result+= obj[el]*check[distance];
                check[distance]+= obj[el];
            }else{
                check[distance] = obj[el];
            }
            
        })
    }
    
    return result;
};