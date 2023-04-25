function solution(arr, n) {
    if(arr.length % 2 === 0){
        arr.forEach((_,idx) => {
            if(idx % 2 !== 0) arr[idx] += n;
        });
    }else{
        arr.forEach((_,idx) => {
            if(idx % 2 === 0) arr[idx] += n;
        });
    }
    
    return arr;
}