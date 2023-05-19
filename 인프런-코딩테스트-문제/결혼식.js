function solution(arr) {
  let result = 0;
  const newArr = [];

  arr.forEach((el) => {
    newArr.push([el[0], "s"]);
    newArr.push([el[1], "e"]);
  });

  newArr.sort((a, b) => {
    if (a[0] !== b[0]) return a[0] - b[0];
    if (a[0] === b[0]) return a[1].charCodeAt() - b[1].charCodeAt();
  });

  let cnt = 0;
  newArr.forEach((el) => {
    if (el[1] === "s") cnt++;
    if (el[1] === "e") cnt--;
    result = Math.max(cnt, result);
  });

  return result;
}

const array = [
  [14, 18],
  [12, 15],
  [15, 20],
  [20, 30],
  [5, 14],
];
console.log(solution(array));
console.log(
  solution([
    [1, 100],
    [2, 50],
    [3, 45],
    [4, 32],
  ])
);
