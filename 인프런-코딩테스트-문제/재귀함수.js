function solution1(n) {
  if (n === 1) return 1;
  return solution1(n - 1) + " " + n;
}

function solution2(n) {
  function DFS(L) {
    if (L === 0) return;
    else {
      DFS(L - 1);
      console.log(L);
    }
  }

  DFS(n);
}

console.log(solution1(3));
console.log(solution2(3));
