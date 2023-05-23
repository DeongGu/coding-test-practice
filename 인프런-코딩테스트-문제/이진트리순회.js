function solution(n) {
  let result = "";
  function DFS(N) {
    if (N > 7) return;
    // 전위순회
    result += N;
    DFS(N * 2);
    // 중위순회
    // result += N;
    DFS(N * 2 + 1);
    // 후위순회
    // result += N;
  }
  DFS(n);
  return result;
}

console.log(solution(1));
