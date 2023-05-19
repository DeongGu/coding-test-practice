function solution(arr) {
  const result = [];
  const newArr = [...arr];
  newArr.sort((a, b) => a - b);

  arr.forEach((el, idx) => {
    if (el !== newArr[idx]) result.push(idx + 1);
  });
  return result;
}

console.log(solution([120, 125, 152, 130, 135, 135, 143, 127, 160]));
console.log(solution([120, 130, 150, 150, 130, 150]));
