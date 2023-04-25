function solution(myString, pat) {
    const idx = [];
    
    for(let i = 0; i < myString.length-pat.length+1; i++){
        const str = myString.slice(i, i+pat.length);
        
        if(str === pat){
            idx.push(i+pat.length);
        }
    }
    
    return myString.slice(0,idx[idx.length-1]);
}