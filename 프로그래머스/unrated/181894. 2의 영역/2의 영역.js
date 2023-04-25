function solution(arr) {
    const idx = [];
    
    for(let i = 0; i < arr.length; i++){
        if(arr[i] === 2) idx.push(i);
    }
    
    return arr.slice(idx[0], idx[idx.length-1]+1).length === 0 ? [-1] : arr.slice(idx[0], idx[idx.length-1]+1);
}