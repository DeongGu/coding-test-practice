function solution(array, n) {
    array.push(n);
    array.sort((a,b) => a-b);
    
    const idx = array.indexOf(n);
    
    if(array[idx+1]){
        
        const pre = array[idx] - array[idx-1];
        const next = array[idx+1] - array[idx];
        
        return pre > next? array[idx+1]: array[idx-1];
    }
    
    return array[idx-1];
}