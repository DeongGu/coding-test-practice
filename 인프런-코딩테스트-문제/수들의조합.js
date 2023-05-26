function solution(n, k, arr, m) {
  let result = 0;
  const tmp = Array.from({ length: k });
  function dfs(l, s, sum) {
    if (l === k) {
      if (sum % m === 0) result++;
    } else {
      for (let i = s; i < n; i++) {
        tmp[l] = arr[i];
        dfs(l + 1, i + 1, sum + arr[i]);
      }
    }
  }
  dfs(0, 0, 0);
  return result;
}

console.log(solution(5, 3, [2, 4, 5, 8, 12], 6));
