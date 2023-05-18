function solution(N, K) {
  const queue = [];
  let answer;

  for (let i = 1; i <= N; i++) {
    queue.push(i);
  }

  while (queue.length) {
    for (let i = 1; i < K; i++) {
      queue.push(queue.shift());
    }
    queue.shift();
    if (queue.length === 1) answer = queue.shift();
  }

  return answer;
}

console.log(solution(8, 3));
console.log(solution(9, 3));
console.log(solution(12, 2));
console.log(solution(14, 5));
console.log(solution(423, 8));
