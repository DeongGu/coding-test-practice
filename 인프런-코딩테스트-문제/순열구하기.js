function solution(N, M, arr) {
  const result = [];
  const check = new Array(N).fill(0);
  const tmp = new Array(M).fill(0);

  function dfs(l) {
    if (l === M) {
      result.push(tmp.slice());
      return;
    } else {
      for (let i = 0; i < N; i++) {
        if (check[i] === 0) {
          check[i] = 1;
          tmp[l] = arr[i];
          dfs(l + 1);
          check[i] = 0;
        }
      }
    }
  }

  dfs(0, 0);
  return result;
}

console.log(solution(3, 2, [3, 6, 9]));
