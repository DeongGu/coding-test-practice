function solution(n) {
  let result = 1;
  for (let i = n; i > 0; i--) {
    result *= i;
  }
  return result;
}

function solution2(n) {
  let result = 1;

  function dfs(N) {
    if (N === 1) return;
    else {
      result *= N;
      dfs(N - 1);
    }
  }

  dfs(n);

  return result;
}

function solution3(n) {
  let result;

  function dfs(N) {
    if (N === 1) return 1;
    else return N * dfs(N - 1);
  }
  result = dfs(n);
  return result;
}

console.log(solution(5));
console.log(solution2(5));
console.log(solution3(5));
