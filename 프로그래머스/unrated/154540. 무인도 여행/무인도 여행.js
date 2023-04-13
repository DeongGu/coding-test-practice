function solution(maps) {
    const visited = new Array(maps.length).fill().map(() => new Array(maps[0].length).fill(false));
    const answer = [];
    
    for(let i = 0; i < maps.length; i++){
        for(let j = 0; j < maps[0].length; j++){
            const result = dfs(i,j);
            if(result !== 0) answer.push(result);
        }
    }
    
    function dfs(x,y){
        if(x < 0 || y < 0 || x >= maps.length || y >= maps[0].length || visited[x][y] || maps[x][y] === "X"){
            return 0;
        }
        
        visited[x][y] = true;
        let result = +maps[x][y];
        
        result += dfs(x - 1, y);
        result += dfs(x , y - 1);
        result += dfs(x + 1, y);
        result += dfs(x, y + 1);
        
        return result;
    }
    if(answer.length === 0){
        return [-1];    
    }else{
        return answer.sort((a,b) => a - b);
    }
    
}