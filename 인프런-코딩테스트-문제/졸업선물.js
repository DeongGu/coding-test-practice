function solution(N, M, arr) {
  let result = [];
  for (let i = 0; i < N; i++) {
    let cnt = 0;
    let sum = 0;

    arr[i][0] = arr[i][0] / 2;

    const sumArr = arr.map((el) => el[0] + el[1]).sort((a, b) => a - b);

    for (let j = 0; j < N; j++) {
      if (sum + sumArr[j] <= M) {
        sum += sumArr[j];
        cnt++;
      } else {
        break;
      }
    }
    result.push(cnt);
    arr[i][0] = arr[i][0] * 2;
  }

  return Math.min(...result);
}

const array = [
  [6, 6],
  [2, 2],
  [4, 3],
  [4, 5],
  [10, 3],
];

console.log(solution(5, 28, array));
