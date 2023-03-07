function solution(s, skip, index) {
    const alpha =['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'];
    
    const skipArr = [...skip];
    
    const newAlpha = alpha.filter(el => !skipArr.includes(el));
    
    const resultAlpha = [...newAlpha, ...newAlpha, ...newAlpha];
    
    const result = [];
    
    s.split("").map((el,idx) => {
        result.push(resultAlpha[newAlpha.indexOf(el)+index]);    
    });
    
    return result.join("");
}