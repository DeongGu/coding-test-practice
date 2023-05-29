function solution(n, arr) {
  let result = 0;

  const dy = Array.from({ length: n }, () => 0);

  dy[0] = 1;

  for (let i = 1; i < n; i++) {
    let check = 0;
    for (let j = i - 1; j >= 0; j--) {
      if (arr[i] > arr[j] && dy[j] > check) check = dy[j];
    }
    dy[i] = check + 1;
    result = Math.max(result, dy[i]);
  }
  return result;
}

console.log(solution(8, [5, 3, 7, 8, 6, 2, 9, 4]));
