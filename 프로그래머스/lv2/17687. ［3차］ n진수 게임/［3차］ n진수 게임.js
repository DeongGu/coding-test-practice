function solution(n, t, m, p) {
    let inputStr = "";
    let result = "";
    
    for(let i = 0; i < t*m; i++){
        inputStr += i.toString(n).toUpperCase();
    }
    
    for(let i = 0; i < t*m; i+=m){
        result+= inputStr.slice(i,i+m)[p-1];        
    }
    
    
    
    return result;
}