function solution(cards1, cards2, goal) {
    for(let i = 0; i < goal.length; i++) {
        if(cards1.length > 0 && goal[i] === cards1[0]){
            cards1.shift();
            continue;
        }
        if(cards2.length > 0 && goal[i] === cards2[0]){
            cards2.shift();
            continue;
        }
        
        return "No";
    }
    
    return "Yes";
}