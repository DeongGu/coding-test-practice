function solution1(N, K, arr) {
  const result = [];
  let lt = 0;

  while (result.length !== arr.length - K + 1) {
    let sum = 0;
    for (let rt = lt; rt < lt + K; rt++) {
      sum += arr[rt];
    }
    lt++;
    result.push(sum);
  }
  return Math.max(...result);
}

function solution2(N, K, arr) {
  const result = [];

  for (let i = 0; i < N - K; i++) {
    let sum = 0;
    for (let j = i; j < i + K; j++) {
      sum += arr[j];
    }
    result.push(sum);
  }
  return Math.max(...result);
}

function solution3(N, K, arr) {
  const result = [];
  let sum = 0;

  for (let i = 0; i < K; i++) {
    sum += arr[i];
  }
  result.push(sum);

  for (let i = K; i < N; i++) {
    sum += arr[i] - arr[i - K];
    result.push(sum);
  }
  return Math.max(...result);
}

function solution4(N, K, arr) {
  let sum = 0;
  let result = 0;

  for (let i = 0; i < K; i++) {
    sum += arr[i];
  }

  result = sum;

  for (let i = K; i < N; i++) {
    sum += arr[i] - arr[i - K];
    result = Math.max(result, sum);
  }
  return result;
}

console.log(solution1(10, 3, [12, 15, 11, 20, 25, 10, 20, 19, 13, 15]));
console.log(solution2(10, 3, [12, 15, 11, 20, 25, 10, 20, 19, 13, 15]));
console.log(solution3(10, 3, [12, 15, 11, 20, 25, 10, 20, 19, 13, 15]));
console.log(solution4(10, 3, [12, 15, 11, 20, 25, 10, 20, 19, 13, 15]));
