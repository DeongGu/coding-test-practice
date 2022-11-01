function solution(k, dungeons) {
    
    const dungeonList = getPermutation(dungeons, dungeons.length);
    const answer = [];
   
    
    for(let i = 0; i < dungeonList.length; i++ ){
        const dungeon = dungeonList[i];
        let count = 0;
        let fatigue = k;
    
        for(let j = 0; j < dungeon.length; j++){
            
            if(dungeon[j][0] <= fatigue && fatigue > 0) {
                count++;
                fatigue -= dungeon[j][1];
            }
        }
        answer.push(count);
    }
    
    return dungeons.length < Math.max(...answer) ? dungeons.length : Math.max(...answer);
    
}

function getPermutation(arr, num) {
    
    const results = []
    
    if(num === 1) return arr.map(x=>[x]);
    
    arr.forEach((fixed, index, origin)=>{
        
        const rest = [...origin.slice(0,index), ...origin.slice(index+1)];
        
        const permutation = getPermutation(rest, num - 1)
        
        const result = permutation.map(x=>[fixed, ...x])
        
        results.push(...result)
        
    })
    return results
}