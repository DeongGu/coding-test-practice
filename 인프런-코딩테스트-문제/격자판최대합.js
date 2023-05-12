function solution(arr) {
  let cross1 = 0;
  let cross2 = 0;
  let row = [];
  let column = [];

  for (let i = 0; i < arr.length; i++) {
    cross1 += arr[i][i];
    cross2 += arr[arr.length - 1 - i][i];
  }

  for (let i = 0; i < arr.length; i++) {
    let check1 = 0;
    let check2 = 0;
    for (let j = 0; j < arr.length; j++) {
      check1 += arr[i][j];
      check2 += arr[j][i];
    }
    row.push(check1);
    column.push(check2);
  }

  return Math.max(...row, ...column, cross1, cross2);
}

let array = [
  [10, 13, 10, 12, 15],
  [12, 39, 30, 23, 11],
  [11, 25, 50, 53, 15],
  [19, 27, 29, 37, 27],
  [19, 13, 30, 13, 19],
];
console.log(solution(array));
