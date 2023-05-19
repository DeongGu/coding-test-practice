function solution(arr) {
  arr.sort((a, b) => {
    if (a[0] !== b[0]) return a[0] - b[0];
    if (a[0] === b[0]) return a[1] - b[1];
  });
  return arr;
}

const array = [
  [2, 7],
  [1, 3],
  [1, 2],
  [2, 5],
  [3, 6],
];
console.log(solution(array));
