function solution(n, arr) {
  let result = 0;

  arr.forEach((el) => (String(el)[1] === String(n) ? result++ : null));

  return result;
}

console.log(solution(3, [25, 23, 11, 47, 53, 17, 33]));

console.log(solution(0, [12, 20, 54, 30, 87, 91, 30]));
