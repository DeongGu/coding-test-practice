function solution(w, h) {
    let result = BigInt(w*h);
    const getCount = (x) => {
        return (-1)*x*h/w + h
    }
    
    for(let i = 1; i <= w; i++){
        let count = Math.ceil(getCount(i-1)) - Math.floor(getCount(i));    
        result-= BigInt(count);
    }
    
    
    return result;
}