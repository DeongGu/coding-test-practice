function solution(name, yearning, photo) {
   let result = [];
    
    const obj = {};
    
    name.map((el,idx) => obj[el] = yearning[idx]);
    
    photo.map((el) => {
        let sum = 0;
        el.map(v => sum += obj[v] ? obj[v] : 0);
        result.push(sum);
    })
    
    return result;
}