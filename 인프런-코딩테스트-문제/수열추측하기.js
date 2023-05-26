function solution(n, f) {
  let result, flag;
  const dy = Array.from(Array(n), () => Array(n).fill(0));
  const check = Array.from({ length: n + 1 }).fill(0);
  const fixed = Array.from({ length: n }).fill(0);
  const tmp = [];

  function combi(N, R) {
    if (dy[N][R] > 0) return dy[N][R];
    if (N === R || R === 0) return 1;
    else return (dy[N][R] = combi(N - 1, R - 1) + combi(N - 1, R));
  }

  function dfs(l, sum) {
    if (flag === 1) return;
    if (l === n && sum === f) {
      result = tmp.slice();
      flag = 1;
    } else {
      for (let i = 1; i <= n; i++) {
        if (check[i] === 0) {
          check[i] = 1;
          tmp.push(i);
          dfs(l + 1, sum + tmp[l] * fixed[l]);
          check[i] = 0;
          tmp.pop();
        }
      }
    }
  }

  for (let i = 0; i < n; i++) {
    fixed[i] = combi(n - 1, i);
  }
  dfs(0, 0);

  return result;
}

console.log(solution(4, 16));
