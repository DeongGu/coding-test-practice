function solution(n) {
  let result = [];
  const check = new Array(n + 1).fill(0);

  function DFS(N) {
    if (N === n + 1) {
      let tmp = "";
      for (let i = 1; i <= n; i++) {
        if (check[i] === 1) tmp += i + " ";
      }
      result.push(tmp.trim());
    } else {
      check[N] = 1;
      DFS(N + 1);
      check[N] = 0;
      DFS(N + 1);
    }
  }

  DFS(1);

  return result;
}

console.log(solution(3));
