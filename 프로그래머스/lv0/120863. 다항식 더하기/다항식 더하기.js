function solution(polynomial) {
    let con = 0;
    const num = polynomial.split(" ").filter((el) => +el).map((el)=> con+= +el);
    
    let coe = 0;
    const coefficient = polynomial.split(" ").filter((el)=> el.includes("x"))

    for(let i = 0; i < coefficient.length; i++){
        
        if(coefficient[i] === "x"){
            coe += 1;
        }else{
            
            coe += +coefficient[i].slice(0,coefficient[i].length-1);
        }
    }
    
    if(con === 0 && coe === 0){
        return 0;
    }else if(con === 0 && coe === 1){
        return `x`;
    }else if(con === 0){
        return `${coe}x`;
    }else if(coe === 0){
        return  `${con}`; 
    }else if(coe === 1){
        return `x + ${con}`;
    }else{
        return `${coe}x + ${con}`;    
    }
}