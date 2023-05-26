function solution(n, m) {
  const result = [];
  const tmp = Array.from({ length: m }, () => 0);

  function dfs(l, s) {
    if (l === m) {
      result.push(tmp.slice());
    } else {
      for (let i = s; i <= n; i++) {
        tmp[l] = i;
        dfs(l + 1, i + 1);
      }
    }
  }

  dfs(0, 1);

  return result;
}

console.log(solution(4, 2));
