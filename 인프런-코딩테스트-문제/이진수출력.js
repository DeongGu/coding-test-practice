function solution1(n) {
  if (n === 0) return "";
  const newN = Math.floor(n / 2);
  const r = n % 2;
  return solution1(newN) + "" + r;
}

function solution2(n) {
  let result = "";

  function DFS(N) {
    if (N === 0) return;
    DFS(Math.floor(N / 2));
    result += N % 2;
  }

  DFS(n);

  return result;
}

console.log(solution1(11));
console.log(solution2(11));
