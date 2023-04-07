function solution(players, callings) {
    const objPlayers = {};
    
    players.forEach((el,idx) => objPlayers[el] = idx);
    
    callings.forEach((el,idx) => {
        if(objPlayers[el] !== 0){
            const player = el;
            const frontPlayer = players[objPlayers[player]-1];
            objPlayers[player]--;
            objPlayers[frontPlayer]++;
            players[objPlayers[player]] = player;
            players[objPlayers[frontPlayer]] = frontPlayer;
            
        }       
    })
    
    return players;
}