function solution(arr) {
  let result = "";

  arr.forEach((el) => (el.length > result.length ? (result = el) : null));
  return result;
}

console.log(solution(["5", "teacher", "time", "student", "beautiful", "good"]));
