function solution(x, y, n) {
  const memo = new Array(y + 1).fill(-1);
  memo[x] = 0;

  for (let i = x; i <= y; i++) {
    if (memo[i] === -1) continue;

    if (i * 3 <= y) {
      if (memo[i * 3] === -1) {
        memo[i * 3] = memo[i] + 1;
      } else {
        memo[i * 3] = Math.min(memo[i * 3], memo[i] + 1);
      }
    }

    if (i * 2 <= y) {
      if (memo[i * 2] === -1) {
        memo[i * 2] = memo[i] + 1;
      } else {
        memo[i * 2] = Math.min(memo[i * 2], memo[i] + 1);
      }
    }

    if (i + n <= y) {
      if (memo[i + n] === -1) {
        memo[i + n] = memo[i] + 1;
      } else {
        memo[i + n] = Math.min(memo[i + n], memo[i] + 1);
      }
    }
  }

  return memo[y];
}