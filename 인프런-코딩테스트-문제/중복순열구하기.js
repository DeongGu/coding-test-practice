function solution1(N) {
  for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= N; j++) {
      console.log(`${i} ${j}`);
    }
  }
}

function solution2(N) {
  function dfs(n) {
    if (n > N) {
      return;
    } else {
      for (let i = 1; i <= N; i++) {
        console.log(`${n} ${i}`);
      }
      dfs(n + 1);
    }
  }
  dfs(1);
}

function solution3(N, M) {
  const result = [];
  const tmp = new Array(M).fill(0);
  function dfs(n) {
    if (n === M) {
      result.push(tmp.slice());
    } else {
      for (let i = 1; i <= N; i++) {
        tmp[n] = i;
        dfs(n + 1);
      }
    }
  }
  dfs(0);

  return result;
}

console.log(solution1(3));
console.log(solution2(3));
console.log(solution3(4, 3));
