function solution(arr) {
    let count = 0;

    while(true){
        
        const standard = [...arr];
        
        for(let i = 0; i < arr.length; i++){
            if(arr[i] > 50 && arr[i] % 2 === 0){
                arr[i] = arr[i]/2;
                continue;
            }
            
            if(arr[i] < 50 && arr[i] % 2 !== 0){
                arr[i] = 2*arr[i]+1;
                continue;
            }
        }
        
        count++;
        
        if(JSON.stringify(arr) === JSON.stringify(standard)) return count-1;
        
    }
}