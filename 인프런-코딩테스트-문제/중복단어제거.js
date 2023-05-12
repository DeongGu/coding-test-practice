function solution1(arr) {
  const set = new Set(arr);
  const result = [...set];

  return result;
}

function solution2(arr) {
  const result = arr.filter((el, idx) => arr.indexOf(el) === idx);
  return result;
}

console.log(solution1(["good", "time", "good", "time", "student"]));

console.log(solution2(["good", "time", "good", "time", "student"]));
