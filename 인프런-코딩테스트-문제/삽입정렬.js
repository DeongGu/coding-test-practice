function solution(arr) {
  for (let i = 0; i < arr.length; i++) {
    let tmp = arr[i];
    for (let j = i - 1; j >= 0; j--) {
      if (arr[j] > tmp) {
        arr[j + 1] = arr[j];
        arr[j] = tmp;
      } else {
        break;
      }
    }
  }
  return arr;
}

console.log(solution([11, 7, 5, 6, 10, 9]));
console.log(solution([11, 7, 5, 6, 10, 9, 432, 43, 13, 4, 3436]));
