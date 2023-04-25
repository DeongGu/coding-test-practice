function solution(l, r) {
  
    const arr = [];
    for(let i = 0; i <= r; i++){
        arr.push(Number((i).toString(2).replace(/1/g,"5")));
    }
    
    const result = arr.filter((el) => l <= el && el <= r);
    
    return result.length === 0 ? [-1] : result;
}
