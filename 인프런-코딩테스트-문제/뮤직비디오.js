function solution1(N, M, arr) {
  let check = 0;
  arr.forEach((el) => (check += el / M));

  let result = [];

  let tmp = 0;
  for (let i = 0; i < arr.length; i++) {
    if (tmp + arr[i] > check) {
      if (i === arr.length - 1) {
        result.push(tmp + arr[i]);
      } else {
        result.push(tmp);
        tmp = 0;
      }
    }
    tmp += arr[i];
  }

  return Math.max(...result);
}

function solution2(N, M, arr) {
  let lt = Math.max(...arr);
  let rt = arr.reduce((a, b) => a + b, 0);

  let mid = Math.floor((lt + rt) / 2);

  let cnt = 0;

  while (cnt !== M) {
    mid = Math.floor((lt + rt) / 2);
    let tmp = 0;
    for (let i = 0; i < arr.length; i++) {
      tmp += arr[i];
      if (tmp + arr[i] > mid) {
        tmp = 0;
        cnt++;
      }
    }

    if (cnt < M) {
      cnt = 0;
      rt = mid - 1;
    }
  }

  return mid;
}

console.log(solution1(9, 3, [1, 2, 3, 4, 5, 6, 7, 8, 9]));
console.log(solution2(9, 3, [1, 2, 3, 4, 5, 6, 7, 8, 9]));
