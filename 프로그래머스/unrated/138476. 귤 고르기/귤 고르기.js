function solution(k, tangerine) {
    const objTangerine = {};
    let cal = 0;
    let result = 0;
    
    tangerine.map(el => objTangerine[el] ? objTangerine[el] += 1 : objTangerine[el] = 1 );
    
    const arrTangerine = Object.values(objTangerine).sort((a,b) => (b-a));
    
    
    for(let i = 0; i < arrTangerine.length; i++){
        if(cal < k){
            cal += arrTangerine[i];
            result+=1;
        }else{
           break;
        }
    }
    
    return result;
}