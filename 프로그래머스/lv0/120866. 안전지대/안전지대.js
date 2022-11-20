function solution(board) {
  const N = board.length
  const dx = [-1, 1, 0, 0, -1, -1, 1, 1]
  const dy = [0, 0, -1, 1, -1, 1, -1, 1]


  const booms = []
  for (let x = 0; x < N; x++) {
    for (let y = 0; y < N; y++) {
      if (board[x][y] === 1) {
        booms.push([x, y])
      }
    }
  }

 
  booms.forEach(([x, y]) => {
    for (let i = 0; i < 8; i++) {
      const nx = x + dx[i]
      const ny = y + dy[i]
      if (0 <= nx && nx < N && 0 <= ny && ny < N) {
        board[nx][ny] = 1
      }
    }
  })

  
  let count = 0
  for (let x = 0; x < N; x++) {
    for (let y = 0; y < N; y++) {
      if (board[x][y] === 0) {
        count++
      }
    }
  }

  return count
}