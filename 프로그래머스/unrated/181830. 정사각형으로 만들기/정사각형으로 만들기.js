function solution(arr) {
    const count1 = arr.length - arr[0].length;
    const count2 = arr[0].length - arr.length;
    
    if(arr.length > arr[0].length){
        for(let i = 0; i < arr.length; i++){
            for(let j = 0; j < count1; j++){
                arr[i].push(0);
            }
        }
    }
    
    if(arr.length < arr[0].length){
        for(let i = 0; i < count2; i++){
            arr.push(new Array(arr[0].length).fill(0));
        }
    }
    
    return arr;
}