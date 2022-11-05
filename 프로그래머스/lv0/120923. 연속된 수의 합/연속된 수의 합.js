function solution(num, total) {
    const first = (total-(num*(num-1)/2))/num;
    
    
    
    const result = [];
    
    for(let i = 0; i < num; i++){
        result.push(first+i);
    }
    
    return result;
}