function solution1(a, b, c, d, e, f, g) {
  return Math.min(a, b, c, d, e, f, g);
}

console.log(solution1(5, 3, 7, 11, 2, 15, 17));

function solution2(arr) {
  let result = Number.MAX_SAFE_INTEGER;

  for (let i = 0; i < arr.length; i++) {
    if (arr[i] < result) result = arr[i];
  }
  return result;
}

console.log(solution2([5, 3, 7, 11, 2, 15, 17]));

function solution3(arr) {
  return Math.min(...arr);
}

console.log(solution3([5, 3, 7, 11, 2, 15, 17]));
