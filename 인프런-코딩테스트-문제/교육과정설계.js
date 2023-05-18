function solution1(course, str) {
  const arr1 = course.split("");
  const arr2 = str.split("");

  const result = arr2.filter((el) => arr1.includes(el)).join("");
  return result === course ? "YES" : "NO";
}

function solution2(c, s) {
  const queue = c.split("");

  for (x of s) {
    if (x === queue[0]) queue.shift();
  }

  return queue.length === 0 ? "YES" : "NO";
}

console.log(solution1("CBA", "CBDAGE"));
console.log(solution1("CBA", "CB"));

console.log(solution2("CBA", "CBDAGE"));
console.log(solution2("CBA", "CB"));
