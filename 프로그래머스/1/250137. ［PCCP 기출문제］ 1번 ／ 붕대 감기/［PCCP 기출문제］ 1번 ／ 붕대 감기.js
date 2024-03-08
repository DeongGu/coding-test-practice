function solution(bandage, health, attacks) {
    const time = attacks[attacks.length-1][0];
    let result = health;
    
    const [ct, rps, ph] = bandage;
    let cs = 0;
    const attackObj = {}
    attacks.forEach((el) => attackObj[el[0]] = el[1]);
    
    for(let i = 1; i < time+1; i++){

        if(attackObj[i]){
            cs = 0;
            result -= attackObj[i];
            if(result <= 0) return -1;
            continue;
        }else{
            result+= rps;
            cs++;
            
            if(result > health) result = health;
            if(cs === ct){
                result+= ph;
                cs = 0;
                if(result > health) result = health;
            }
        }
        
    }
    
    return result;
}