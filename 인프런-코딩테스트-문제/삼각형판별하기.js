function solution(a, b, c) {
  let max = 0;
  let sum = a + b + c;

  if (a > b) max = a;
  else max = b;

  if (max < c) max = c;

  if (sum - max > max) return "YES";

  return "NO";
}

console.log(solution(13, 33, 17));
