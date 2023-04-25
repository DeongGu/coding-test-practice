function solution(strArr) {
    const newArr = strArr.map((el,idx) => {
        if(idx%2 === 0) return el.toLowerCase();
        else return el.toUpperCase();
    })
    
    return newArr;
}