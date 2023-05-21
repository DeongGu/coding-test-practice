function solution1(M, arr) {
  arr.sort((a, b) => a - b);
  return arr.indexOf(M) + 1;
}

function solution2(M, arr) {
  arr.sort((a, b) => a - b);
  let lt = 0;
  let rt = arr.length - 1;
  let mid = Math.floor((lt + rt) / 2);

  while (arr[mid] !== M) {
    if (arr[mid] > M) {
      rt = mid + 1;
    } else {
      lt = mid - 1;
    }
    mid = Math.floor((lt + rt) / 2);
  }

  return mid + 1;
}

console.log(solution1(32, [23, 87, 65, 12, 57, 32, 99, 81]));
console.log(solution2(32, [23, 87, 65, 12, 57, 32, 99, 81]));
