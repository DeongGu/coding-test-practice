function solution(C, N, arr) {
  let result = 0;

  function DFS(l, sum) {
    if (sum > C) return;
    if (l === N) {
      result = Math.max(result, sum);
    } else {
      DFS(l + 1, sum + arr[l]);
      DFS(l + 1, sum);
    }
  }

  DFS(0, 0);
  return result;
}

console.log(solution(259, 5, [81, 58, 42, 33, 61]));
