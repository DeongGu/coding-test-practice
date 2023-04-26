function solution(arr) {
    let count = 1;
    while(true){
        if(arr.length <= count){
            const ct = count - arr.length;
            for(let i = 0; i < ct; i++){
                arr.push(0);
            }
            
            return arr;
        }
        count*=2;
    }
}