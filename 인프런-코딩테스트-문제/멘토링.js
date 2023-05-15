function solution(N, M, arr) {
  let result = 0;
  const newArr = new Array(N).fill().map(() => new Array());

  for (let i = 0; i < M; i++) {
    for (let j = 1; j <= N; j++) {
      newArr[j - 1].push(arr[i].indexOf(j) + 1);
    }
  }

  for (let i = 0; i < N - 1; i++) {
    let check = 0;
    for (let j = i + 1; j < N; j++) {
      for (let k = 0; k < M; k++) {
        if (newArr[i][k] < newArr[j][k]) break;
        check++;
      }
      if (check === M) {
        result++;
        check = 0;
      }
    }
  }

  return result;
}

const array = [
  [3, 4, 1, 2],
  [4, 3, 2, 1],
  [3, 1, 4, 2],
];
console.log(solution(4, 3, array));
