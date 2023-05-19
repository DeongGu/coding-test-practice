function solution1(arr) {
  let result = 0;
  arr.sort((a, b) => {
    if (a[0] !== b[0]) return a[0] - b[0];
    if (a[0] === b[0]) return a[1] - b[1];
  });

  for (let i = 0; i < arr.length - 1; i++) {
    let tmp = arr[i];
    let cnt = 1;
    for (let j = i + 1; j < arr.length; j++) {
      if (tmp[1] <= arr[j][0]) {
        cnt++;
        tmp = arr[j];
      }
    }
    result = Math.max(result, cnt);
  }

  return result;
}

function solution2(arr) {
  let result = 0;
  arr.sort((a, b) => {
    if (a[1] === b[1]) return a[0] - b[0];
    else return a[1] - b[1];
  });

  let et = 0;
  for (let x of arr) {
    if (x[0] >= et) {
      result++;
      et = x[1];
    }
  }
  return result;
}

const array = [
  [1, 4],
  [2, 3],
  [3, 5],
  [4, 6],
  [5, 7],
];
console.log(solution1(array));
console.log(
  solution1([
    [3, 3],
    [1, 3],
    [2, 3],
  ])
);

console.log(
  solution1([
    [3, 3],
    [1, 3],
    [2, 3],
    [5, 7],
    [5, 5],
  ])
);

console.log(solution2(array));
console.log(
  solution2([
    [3, 3],
    [1, 3],
    [2, 3],
  ])
);

console.log(
  solution2([
    [3, 3],
    [1, 3],
    [2, 3],
    [5, 7],
    [5, 5],
  ])
);
