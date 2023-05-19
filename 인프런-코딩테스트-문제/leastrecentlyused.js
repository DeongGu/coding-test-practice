function solution1(S, N, arr) {
  const result = [];
  for (let i = 0; i < N; i++) {
    if (result.includes(arr[i])) {
      result.splice(result.indexOf(arr[i]), 1);
      result.unshift(arr[i]);
      continue;
    }
    result.unshift(arr[i]);
    if (result.length > S) result.pop();
  }
  return result;
}

function solution2(S, N, arr) {
  const result = new Array(S).fill(0);
  for (let i = 0; i < N; i++) {
    if (result.includes(arr[i])) {
      for (let j = result.indexOf(arr[i]); j > 0; j--) {
        result[j] = result[j - 1];
      }
    } else {
      for (let j = S - 1; j > 0; j--) {
        result[j] = result[j - 1];
      }
    }
    result[0] = arr[i];
  }
  return result;
}

console.log(solution1(5, 9, [1, 2, 3, 2, 6, 2, 3, 5, 7]));
console.log(solution2(5, 9, [1, 2, 3, 2, 6, 2, 3, 5, 7]));
