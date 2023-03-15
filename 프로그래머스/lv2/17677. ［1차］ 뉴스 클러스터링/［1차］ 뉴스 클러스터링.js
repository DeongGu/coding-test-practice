function solution(str1, str2) {
    const str1Arr = [];
    const str2Arr = [];
    
    const newStr1 = str1.toLowerCase();
    const newStr2 = str2.toLowerCase();
    
    for(let i = 0; i < newStr1.length; i++){
        if(["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"].includes(newStr1[i]) && ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"].includes(newStr1[i+1])){
        str1Arr.push(newStr1.slice(i,i+2));
    }
    }
    for(let i = 0; i < newStr2.length; i++){
        if(["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"].includes(newStr2[i]) && ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"].includes(newStr2[i+1])){
        str2Arr.push(newStr2.slice(i,i+2));
    }    
    }

    const same = [];
    const diff = [];
    
   for(let i = 0 ; i < str1Arr.length ; i ++) {
       if(str2Arr.includes(str1Arr[i])) {
           const idx = str2Arr.indexOf(str1Arr[i]);
           str2Arr.splice(idx,1);
           same.push(str1Arr[i]);
       } else {
           diff.push(str1Arr[i])
       }
   }

    str2Arr.forEach((e) => diff.push(e));

    
    if(diff.length === 0 ) return 65536;
    
    const result = Math.floor((same.length / (same.length+diff.length)) * 65536);
    
    return result;
}
