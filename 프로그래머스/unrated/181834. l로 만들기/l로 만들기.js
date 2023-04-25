function solution(myString) {
    const arr = myString.split("");
    
    for(let i = 0; i < arr.length; i++){
        if(arr[i].charCodeAt() < "l".charCodeAt()){
            arr[i] = "l";
        }
    }
    
    return arr.join("");
}