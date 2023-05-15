function solution(N, K, arr) {
  const result = [];

  for (let i = 0; i < N - 2; i++) {
    for (let j = i + 1; j < N - 1; j++) {
      for (let k = j + 1; k < N; k++) {
        result.push(arr[i] + arr[j] + arr[k]);
      }
    }
  }

  const set = new Set(result);
  const answer = [...set].sort((a, b) => b - a);
  return answer[K - 1];
}

console.log(solution(10, 3, [13, 15, 34, 23, 45, 65, 33, 11, 26, 42]));
