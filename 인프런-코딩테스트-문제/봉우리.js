function solution1(arr) {
  let result = 0;

  for (let i = 1; i < arr.length - 1; i++) {
    for (let j = 1; j < arr.length - 1; j++) {
      if (
        arr[i][j] > arr[i - 1][j] &&
        arr[i][j] > arr[i][j - 1] &&
        arr[i][j] > arr[i + 1][j] &&
        arr[i][j] > arr[i][j + 1]
      ) {
        result++;
      }
    }
  }
  return result;
}

function solution2(arr) {
  let result = 0;
  let dx = [-1, 0, 1, 0];
  let dy = [0, 1, 0, -1];

  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr.length; j++) {
      let top = 1;
      for (let k = 0; k < 4; k++) {
        let nx = i + dx[k];
        let ny = j + dy[k];

        if (
          nx >= 0 &&
          nx < arr.length &&
          ny >= 0 &&
          ny < arr.length &&
          arr[nx][ny] >= arr[i][j]
        ) {
          top = 0;
          break;
        }
      }
      if (top) result++;
    }
  }
  return result;
}

const array = [
  [0, 0, 0, 0, 0, 0, 0],
  [0, 5, 3, 7, 2, 3, 0],
  [0, 3, 7, 1, 6, 1, 0],
  [0, 7, 2, 5, 3, 4, 0],
  [0, 4, 3, 6, 4, 1, 0],
  [0, 8, 7, 3, 5, 2, 0],
  [0, 0, 0, 0, 0, 0, 0],
];
console.log(solution1(array));
console.log(solution2(array));
