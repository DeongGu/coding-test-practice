function solution(array) {
    const answer = {};
    
    array.map((el,idx)=> answer[el] ? answer[el]++ : answer[el] = 1);
    
    const values = Object.values(answer);
    
    const count = values.reduce((cnt,el)=>cnt+(Math.max(...values) === el),0);
    
    
    
    if(count > 1){
        return -1;
    }else{
        
       const idx = values.indexOf(Math.max(...values))
       
       return +Object.keys(answer)[idx];
    }
}