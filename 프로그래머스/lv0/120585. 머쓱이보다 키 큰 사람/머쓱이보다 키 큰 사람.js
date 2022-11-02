function solution(array, height) {
    const result = array.filter((x)=> x > height);
    
    return result.length;
}