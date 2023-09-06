function solution(queue1, queue2) {
    let sum1 = queue1.reduce((a,b) => a+b, 0);
    const sum2 = queue2.reduce((a,b) => a+b, 0);
    const order = (sum1+sum2)/2;
    
    if(order !== Math.floor(order)) return -1;
    
    const filteredQueue1 = queue1.filter((el) => el > order);
    const filteredQueue2 = queue2.filter((el) => el > order);
    
    if(filteredQueue1.length > 0 || filteredQueue2.length > 0) return -1;
    
    const filteredQueue3 = queue1.filter((el) => el === order);
    const filteredQueue4 = queue2.filter((el) => el === order);
    
    if(filteredQueue3.length === 1 && filteredQueue4.length !== 1){
        const indexOfOrder1 = queue1.indexOf(order);
        return indexOfOrder1*2 + 1 + queue2.length;
    }
    
    if(filteredQueue4.length === 1 && filteredQueue3.length !== 1){
        const indexOfOrder2 = queue2.indexOf(order);
        return indexOfOrder2*2 + 1 + queue1.length;
    }

    
    let pointer1 = 0;
    let pointer2 = 0;
    
    while(sum1 !== order){
        if(sum1 > order){
            sum1 -= queue1[pointer1];
            pointer1++;
        }
        
        if(sum1 < order){
            sum1 += queue2[pointer2];
            pointer2++;
        }
        
        if(pointer1 >= queue1.length || pointer2 >= queue2.length) return -1;
    }
    
    return pointer1 + pointer2;
}