function solution(intStrs, k, s, l) {
    const result = [];
    
    intStrs.forEach((el) => {
        let int = parseInt(el.slice(s,s+l));

        if(int > k) result.push(int);
    })
    
    return result;
}