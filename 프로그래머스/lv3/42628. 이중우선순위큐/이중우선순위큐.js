function solution(operations) {
    const newOperations = operations.map((el) => el.split(" "));
    const arr = [];
    
    for(const [order, number] of newOperations){
        if(order === "I") arr.push(+number);
        if(order === "D" && number === "1" && arr.length >= 1) {
            const max = Math.max(...arr);
            const maxIndex = arr.indexOf(max);
            arr.splice(maxIndex, 1);
        }
        
        if(order === "D" && number === "-1" && arr.length >= 1){
            const min = Math.min(...arr);
            const minIndex = arr.indexOf(min);
            arr.splice(minIndex, 1);
        }
    }
    
    if(arr.length === 0 ) return [0,0];
    else{
        const max = Math.max(...arr);
        const min = Math.min(...arr);
        return [max, min];
    }
    
}