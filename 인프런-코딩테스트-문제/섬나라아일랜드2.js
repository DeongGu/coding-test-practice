function solution(arr) {
  let result = 0;
  const dx = [-1, -1, -1, 0, 0, 1, 1, 1];
  const dy = [-1, 0, 1, -1, 1, -1, 0, 1];
  const queue = [];

  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr.length; j++) {
      if (arr[i][j] === 1) {
        arr[i][j] = 0;
        queue.push([i, j]);
        result++;
        while (queue.length) {
          const [x, y] = queue.shift();

          for (let k = 0; k < 8; k++) {
            const nx = x + dx[k];
            const ny = y + dy[k];

            if (
              nx >= 0 &&
              nx < arr.length &&
              ny >= 0 &&
              ny < arr.length &&
              arr[nx][ny] === 1
            ) {
              arr[nx][ny] = 0;
              queue.push([nx, ny]);
            }
          }
        }
      }
    }
  }
  return result;
}

const array = [
  [1, 1, 0, 0, 0, 1, 0],
  [0, 1, 1, 0, 1, 1, 0],
  [0, 1, 0, 0, 0, 0, 0],
  [0, 0, 0, 1, 0, 1, 1],
  [1, 1, 0, 1, 1, 0, 0],
  [1, 0, 0, 0, 1, 0, 0],
  [1, 0, 1, 0, 1, 0, 0],
];
console.log(solution(array));
