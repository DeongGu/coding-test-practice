function solution(numbers, target) {
    
    let result = 0;
    
    dfs(0,0);
    
    function dfs(d,sum){
        if(d === numbers.length){
            if(sum === target){
                result+=1;
            }
            return;
        }
        
        dfs(d+1, sum + numbers[d]);
        dfs(d+1, sum - numbers[d]);
        
    }
    
    return result;
}