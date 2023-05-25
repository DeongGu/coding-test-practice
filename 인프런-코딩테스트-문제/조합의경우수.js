function solution(n, r) {
  const dy = new Array(n + 1).fill().map(() => Array(r + 1).fill(0));
  function dfs(N, R) {
    if (dy[N][R] > 0) return dy[N][R];
    if (N === R || R === 0) return 1;
    else return (dy[N][R] = dfs(N - 1, R - 1) + dfs(N - 1, R));
  }
  return dfs(n, r);
}
console.log(solution(5, 3));
console.log(solution(33, 19));
