function solution(genres, plays) {
    const obj = {};
    const objSum = {}
    const arrSum = [];
    const result =[];
    
    genres.forEach((el,idx) => {
        obj[el] ? obj[el].push([idx,plays[idx]]) : obj[el] = [[idx,plays[idx]]];
        
        obj[el].sort((a,b) => b[1] - a[1]);
    });
    
     genres.forEach((el,idx) => objSum[el] ? objSum[el]+= plays[idx] : objSum[el] = plays[idx]);
    
    Object.keys(objSum).forEach((el,idx) => arrSum.push([el, Object.values(objSum)[idx]]));
    
    arrSum.sort((a,b) => b[1] - a[1]);
    
    arrSum.forEach((el,idx) => {
        // [[0,34],[5,324]....]
        obj[el[0]]
        
        for(let i = 0; i < 2; i++){
            if(obj[el[0]][i]){
                result.push(obj[el[0]][i][0]);    
            }
        }
                               
    })
    
    return result;
}