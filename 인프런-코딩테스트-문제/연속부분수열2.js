function solution(N, M, arr) {
  let result = 0,
    lt = 0,
    sum = 0;

  for (let rt = 0; rt < N; rt++) {
    sum += arr[rt];
    while (sum > M) {
      sum -= arr[lt++];
    }

    result += rt - lt + 1;
  }
  return result;
}

console.log(solution(5, 5, [1, 3, 1, 2, 3]));
