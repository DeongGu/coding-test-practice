function solution(arr) {
  const result = [];

  let max = 0;

  for (let x of arr) {
    let sum = x
      .toString()
      .split("")
      .reduce((a, b) => a + parseInt(b), 0);
    if (max <= sum) {
      max = sum;
      result.push(x);
    }
  }

  return Math.max(...result);
}

console.log(solution([128, 460, 603, 40, 521, 137, 123]));
