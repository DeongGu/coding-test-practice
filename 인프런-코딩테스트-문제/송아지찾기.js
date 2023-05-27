function solution(s, e) {
  let result = 0;
  const queue = [];
  queue.push(s);

  while (queue.length) {
    if (queue.length === 3 ** result) {
      result++;
    }
    let v = queue.shift();
    for (let nv of [v - 1, v + 1, v + 5]) {
      if (nv === e) return result;
      else {
        queue.push(nv);
      }
    }
  }
}

function solution2(s, e) {
  const check = Array.from({ length: 10001 }, () => 0);
  const distance = Array.from({ length: 10001 }, () => 0);
  const queue = [];
  check[s] = 1;
  queue.push(s);
  distance[s] = 0;

  while (queue.length) {
    let v = queue.shift();
    for (let nv of [v - 1, v + 1, v + 5]) {
      if (nv === e) return distance[v] + 1;
      if (nv > 0 && nv <= 10000 && check[nv] === 0) {
        check[nv] = 1;
        queue.push(nv);
        distance[nv] = distance[v] + 1;
      }
    }
  }
}

console.log(solution(5, 14));
console.log(solution(8, 3));
console.log(solution(5, 16));
console.log(solution(5, 11));

console.log(solution2(5, 14));
console.log(solution2(8, 3));
console.log(solution2(5, 16));
console.log(solution2(5, 11));
