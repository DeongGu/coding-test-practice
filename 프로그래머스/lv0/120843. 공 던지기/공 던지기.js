function solution(numbers, k) {
    if(2*k-2 < numbers.length){
        return numbers[2*k-2];
    }
    
    return numbers[(2*k-2)%numbers.length];
}