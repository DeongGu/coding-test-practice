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

function solution2(n, m, arr) {
  const dy = Array.from({ length: m + 1 }, () => 0);

  for (let i = 0; i < n; i++) {
    let ps = arr[i][0];
    let pt = arr[i][1];
    for (let j = m; j >= pt; j--) {
      dy[j] = Math.max(dy[j], dy[j - pt] + ps);
    }
  }

  return dy[m];
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

console.log(
  solution2(5, 20, [
    [10, 5],
    [25, 12],
    [15, 8],
    [6, 3],
    [7, 4],
  ])
);
