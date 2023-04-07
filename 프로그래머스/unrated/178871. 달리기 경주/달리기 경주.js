function solution(players, callings) {
  // players의 순서를 저장할 객체 생성
  const playerOrder = {};
  for (let i = 0; i < players.length; i++) {
    playerOrder[players[i]] = i;
  }

  // callings을 순회하면서 playerOrder 업데이트
  for (let i = 0; i < callings.length; i++) {
    const player = callings[i];
    // 이미 1위인 경우 패스
    if (playerOrder[player] === 0) continue;
    // player의 바로 앞 선수의 이름을 찾아서 추월
    const prevPlayer = players[playerOrder[player] - 1];
    playerOrder[prevPlayer]++;
    playerOrder[player]--;
    // players 배열에서도 순서 변경
    const temp = players[playerOrder[prevPlayer]];
    players[playerOrder[prevPlayer]] = players[playerOrder[player]];
    players[playerOrder[player]] = temp;
  }

  return players;
}