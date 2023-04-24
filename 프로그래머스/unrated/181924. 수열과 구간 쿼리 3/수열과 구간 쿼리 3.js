function solution(arr, queries) {
    for(let i = 0; i < queries.length; i++){
        const first = queries[i][0];
        const firstValue = arr[first];
        const second = queries[i][1];
        const secondValue = arr[second];
        
        arr[first] = secondValue;
        arr[second] = firstValue;
    }
    
    return arr;
}