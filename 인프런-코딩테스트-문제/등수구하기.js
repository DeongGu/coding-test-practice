function solution(arr) {
  const result = [];

  for (let i = 0; i < arr.length; i++) {
    let rank = 1;
    for (let j = 0; j < arr.length; j++) {
      if (arr[i] < arr[j]) rank++;
    }
    result.push(rank);
  }

  return result;
}

console.log(solution([92, 92, 92, 100, 76]));
