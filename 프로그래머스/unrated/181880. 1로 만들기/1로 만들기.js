function solution(num_list) {
    let result = 0;
    
    for(let i = 0; i < num_list.length; i++){
        let count = 0;
        let order = num_list[i];
        while(order !== 1){
            if(order % 2 === 0){
                order = order/2;
                count++;
            }else{
                order = (order-1)/2;
                count++;
            }
        }
        
        result += count;
    }
    
    return result;
}