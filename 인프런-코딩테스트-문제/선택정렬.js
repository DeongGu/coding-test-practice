function solution1(arr) {
  const result = [];

  for (let i = 0; i < arr.length; i++) {
    let idx = i;
    for (let j = i + 1; j < arr.length; j++) {
      if (arr[j] < arr[idx]) idx = j;
    }
    result.push(arr[idx]);
    arr[idx] = arr[i];
  }

  return result;
}

function solution2(arr) {
  for (let i = 0; i < arr.length - 1; i++) {
    let idx = i;
    for (let j = i + 1; j < arr.length; j++) {
      if (arr[j] < arr[idx]) idx = j;
    }

    [arr[idx], arr[i]] = [arr[i], arr[idx]];
  }

  return arr;
}

console.log(solution1([13, 5, 11, 7, 23, 15]));
console.log(solution2([13, 5, 11, 7, 23, 15]));
