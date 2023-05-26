function solution(n, arr) {
  let result = 0;

  const graph = Array.from(Array(n + 1), () => Array());
  const check = Array.from({ length: n + 1 }, () => 0);
  const path = [];
  for (let [a, b] of arr) {
    graph[a].push(b);
  }
  function dfs(l) {
    if (l === n) result++, console.log(path);
    else {
      for (let i = 0; i < graph[l].length; i++) {
        if (check[graph[l][i]] === 0) {
          check[graph[l][i]] = 1;
          path.push(graph[l][i]);
          dfs(graph[l][i]);
          check[graph[l][i]] = 0;
          path.pop();
        }
      }
    }
  }
  path.push(1);
  check[1] = 1;
  dfs(1);

  return result;
}

const array = [
  [1, 2],
  [1, 3],
  [1, 4],
  [2, 1],
  [2, 3],
  [2, 5],
  [3, 4],
  [4, 2],
  [4, 5],
];
console.log(solution(5, array));
