function solution(numbers, target) {
    
    let result = 0;
    
    dfs(0,0);
    
    function dfs(idx,sum){
        if(idx === numbers.length){
            if(sum === target){
                result+=1;
            }
            return;
        }
        
        dfs(idx+1, sum + numbers[idx]);
        dfs(idx+1, sum - numbers[idx]);
        
    }
    
    return result;
}