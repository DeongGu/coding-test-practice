function solution(strArr) {
    const result = [];
    
    strArr.forEach((el) => {
        if(!el.includes("ad")) result.push(el);
    })
    
    return result;
}