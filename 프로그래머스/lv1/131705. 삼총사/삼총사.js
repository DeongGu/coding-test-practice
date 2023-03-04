function solution(number) {
    let answer = 0;
    
    const combination = (arr, index) => {
        if(arr.length === 3){
            answer += arr.reduce((acc,cur) => acc+cur,0) === 0 ? 1 : 0;
            return;
        }
        
        for(let i = index; i < number.length; i++){
            combination([...arr,number[i]],i+1);
        }
    }
    
    combination([],0);
        
    return answer;    
}