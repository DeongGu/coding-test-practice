function solution(p) {

    const elementP = {
        "(":1,
        ")":-1
    }

    const repeat = (w) => {
        let check = 0;
        
        if(w.length === 0) return "";
        
        for(let i = 0; i < w.length; i++){
            check += elementP[w[i]];
            
            if(check === 0){
                const u = w.slice(0,i+1);
                const v = w.slice(i+1);
                
                for(let j = 0; j < u.length; j++ ){
                    check+= elementP[u[j]];
                    if(check < 0){
                        let re = "("+repeat(v)+")";
                        const newU = u.split("");
                        newU.shift();
                        newU.pop();
                        
                        for(let k = 0; k < newU.length; k++){
                            if(newU[k] === "("){
                                newU[k] = ")";
                            }else{
                                newU[k] = "(";
                            }
                        }
                        
                        return re + newU.join("");
                    }
                }
                
                return u + repeat(v);
                
            }
        }
        
        return w;
    }
    
    const result = repeat(p);
    return result;
}