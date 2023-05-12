function solution(arr1, arr2) {
  const result = [];

  for (let i = 0; i < arr1.length; i++) {
    if (arr1[i] === arr2[i]) {
      result.push("D");
      continue;
    }
    if (
      (arr1[i] === 1 && arr2[i] === 2) ||
      (arr1[i] === 2 && arr2[i] === 3) ||
      (arr1[i] === 3 && arr2[i] === 1)
    ) {
      result.push("B");
    } else {
      result.push("A");
    }
  }

  return result;
}

console.log(solution([2, 3, 3, 1, 3], [1, 1, 2, 2, 3]));
