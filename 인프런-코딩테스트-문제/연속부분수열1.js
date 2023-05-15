function solution1(N, M, arr) {
  let result = 0;
  for (let i = 0; i < N; i++) {
    let sum = 0;
    for (let j = i; j < N; j++) {
      sum += arr[j];
      if (sum === M) {
        result++;
        break;
      }
    }
  }
  return result;
}

function solution2(N, M, arr) {
  let result = 0;
  let lt = 0;
  let sum = 0;

  for (let rt = 0; rt < N; rt++) {
    sum += arr[rt];
    if (sum === M) result++;
    while (sum >= M) {
      sum -= arr[lt++];
      if (sum === M) result++;
    }
  }

  return result;
}

console.log(solution1(8, 6, [1, 2, 1, 3, 1, 1, 1, 2]));
console.log(solution2(8, 6, [1, 2, 1, 3, 1, 1, 1, 2]));
