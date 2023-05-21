function solution(C, arr) {
  arr.sort((a, b) => a - b);

  let result = 0;
  let lt = 1;
  let rt = arr[arr.length - 1];

  let mid = Math.floor((lt + rt) / 2);

  while (lt <= rt) {
    mid = Math.floor((lt + rt) / 2);
    let ep = arr[0];
    let cnt = 1;
    for (let i = 1; i < arr.length; i++) {
      if (arr[i] - ep >= mid) {
        cnt++;
        ep = arr[i];
      }
    }

    if (cnt >= C) {
      lt = mid + 1;
      result = mid;
    } else {
      rt = mid - 1;
    }
  }

  return result;
}

console.log(solution(3, [1, 2, 8, 4, 9]));
