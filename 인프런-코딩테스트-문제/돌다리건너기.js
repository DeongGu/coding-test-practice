function solution(n) {
  const dy = Array.from({ length: n + 2 }, () => 0);

  dy[0] = 1;
  dy[1] = 1;
  dy[2] = 2;

  for (let i = 3; i <= n + 1; i++) {
    dy[i] = dy[i - 1] + dy[i - 2] + dy[i - 3];
  }
  return dy[n + 1];
}

console.log(solution(7));
