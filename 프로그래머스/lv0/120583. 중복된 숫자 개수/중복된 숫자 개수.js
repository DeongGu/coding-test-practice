function solution(array, n) {
    const result = array.filter((x)=> x === n);
    
    return result.length;
}