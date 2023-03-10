function solution(n,a,b)
{
    let answer = 1;
    
    const repeat = (A,B) => {
        
        if(A === 1 && B === 2) return;
        if(A === 2 && B === 1) return;
        
        const newA = A%2=== 0 ? A/2 : Math.floor(A/2)+1; 
        const newB = B%2=== 0 ? B/2 : Math.floor(B/2)+1; 

        if(newA === newB) return;
        
        answer +=1;
        
        return repeat(newA, newB);
    }
    
    repeat(a,b);
    
    return answer;
}