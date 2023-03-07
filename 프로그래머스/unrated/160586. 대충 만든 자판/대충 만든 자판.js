function solution(keymap, targets) {
    
    const result = [];
    const alpha = {}
    
    keymap.map((el) => {
        const key = el.split("").map((e, idx) => {
            if(!alpha[e] || alpha[e] > idx+1 ) alpha[e] = idx+1;
        })
    })
    
    targets.map((el) => {
        
        let sumCount = 0;
        const target = el.split("").map(e => {
            sumCount += alpha[e];               
        });
        
        if(sumCount){
            result.push(sumCount)
        }else{
            result.push(-1);
        };
    
    })
    
        return result;
}