function solution(s) {
    let answer = 0;
    const sArr = s.split("");
    
    const repeat = () => {
        let same = 0;
        let diff = 0;
        
        if(sArr.length === 0) {
            return;
        }

        
        for(let i = 0; i<sArr.length; i++){
            
            if(same>=1 && diff>=1 && same === diff){
                answer+=1;
                sArr.splice(0,i);
                return repeat();
            }
            
            if(sArr[0] === sArr[i]) {
                same+=1;
            }else{
                diff+=1;
            }   
        }
        
        answer+=1;
        return;
            
    }
    
    
    repeat();
    
    return answer;
}