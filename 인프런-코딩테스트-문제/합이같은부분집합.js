function solution(n, arr) {
  let result = "NO";
  const total = arr.reduce((a, b) => a + b, 0);
  let check = 0;

  function DFS(num, sum) {
    if (check === 1) return;
    if (num === n) {
      if (total - sum === sum) {
        result = "YES";
        check = 1;
      }
    } else {
      DFS(num + 1, sum + arr[num]);
      DFS(num + 1, sum);
    }
  }

  DFS(0, 0);

  return result;
}

console.log(solution(6, [1, 3, 5, 6, 7, 10]));
