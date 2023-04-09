function solution(n, wires) {
  let answer = n;

  for (let i = 0; i < wires.length; i++) {
    const copyWires = [...wires];
    const [a, b] = copyWires.splice(i, 1)[0];

    const visited = new Array(n + 1).fill(false);
    visited[a] = true;

    const queue = [a];
    let count = 1;

    while (queue.length > 0) {
      const node = queue.shift();
      for (const [from, to] of copyWires) {
        if (from === node && !visited[to]) {
          visited[to] = true;
          queue.push(to);
          count += 1;
        } else if (to === node && !visited[from]) {
          visited[from] = true;
          queue.push(from);
          count += 1;
        }
      }
    }

    answer = Math.min(answer, Math.abs(n - 2 * count));
  }

  return answer;
}