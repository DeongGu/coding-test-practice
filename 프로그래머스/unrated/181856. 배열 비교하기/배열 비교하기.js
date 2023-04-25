function solution(arr1, arr2) {
    if(arr1.length > arr2.length) return 1;
    if(arr1.length < arr2.length) return -1;
    
    let sum1 = 0;
    let sum2 = 0;
    
    arr1.forEach(el => sum1+= el);
    arr2.forEach(el => sum2+= el);
    
    return sum1 === sum2 ? 0 : sum1 > sum2 ? 1 : -1;
}