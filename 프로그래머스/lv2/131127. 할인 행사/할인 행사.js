function solution(want, number, discount) {
    let result = 0;
    
    const objInputCount = {};
    
    want.map((el,idx) => objInputCount[el] = number[idx]);
    
    for(let i = 0; i < discount.length-9; i++){
        
        const objCount = {};
        const selectDiscount = discount.slice(i,i+10);
        let check = 0;
        
        selectDiscount.map((el) => {
            if(!objCount[el]){
                objCount[el] = 1;
            }else{
                objCount[el] += 1;
            }
        })
        
        want.map((el) => {
            if(objInputCount[el] <= objCount[el]) {
                check+=1;
            }
        });
        
        if(check === want.length) result+=1;
       
    }
    
    return result;
}