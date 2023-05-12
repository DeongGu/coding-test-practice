function solution(arr) {
  let result = 0;
  let check = 0;

  for (let i = 0; i < arr.length; i++) {
    if (check < arr[i]) {
      check = arr[i];
      result++;
    }
  }
  return result;
}

console.log(solution([130, 135, 148, 145, 150, 153]));
