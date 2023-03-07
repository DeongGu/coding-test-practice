function solution(wallpaper) {
    const result = [];
    let checkOne = 0;
    let checkTwo = [];
    let checkThree = 0;
    let checkFour = 0;
    
    wallpaper.map((el, idx) => {
        if(checkOne === 0 && el.indexOf("#") !== -1){
            result.push(idx);
            checkOne+=1;
        }
        
        if(el.indexOf("#") !== -1) checkTwo.push(el.indexOf("#"));
        
        if(el.lastIndexOf("#") >= checkFour){
            checkFour = el.lastIndexOf("#")+1 < 0 ? 0 : el.lastIndexOf("#")+1;
        }
        
         if(el.indexOf("#") !== -1){
            checkThree = idx+1;    
         }
        
    })
    
    result.push(Math.min(...checkTwo));
    result.push(checkThree);
    result.push(checkFour);
    
    
    
    return result;
}