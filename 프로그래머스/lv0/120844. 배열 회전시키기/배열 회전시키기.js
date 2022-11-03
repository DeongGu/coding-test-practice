function solution(numbers, direction) {
    
    if(direction === "right") {
        const result = numbers.slice(0,numbers.length-1);
        result.unshift(numbers[numbers.length-1]);
        return result;
    } else if(direction === "left"){
        const result = numbers.slice(1,numbers.length);
        result.push(numbers[0]);
        return result;
    }
}