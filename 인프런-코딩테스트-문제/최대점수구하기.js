function solution(N, RT, arr) {
  let result = 0;

  function DFS(l, sum, time) {
    if (time > RT) return;
    if (l === N) {
      result = Math.max(result, sum);
    } else {
      DFS(l + 1, sum + arr[l][0], time + arr[l][1]);
      DFS(l + 1, sum, time);
    }
  }

  DFS(0, 0, 0);

  return result;
}

console.log(
  solution(5, 20, [
    [10, 5],
    [25, 12],
    [15, 8],
    [6, 3],
    [7, 4],
  ])
);
