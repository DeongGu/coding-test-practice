function solution(arr, M) {
  arr.sort((a, b) => b - a);

  let result = 0;

  let check = M;
  let idx = 0;

  while (idx !== arr.length) {
    if (check % arr[idx] === 0) {
      result += check / arr[idx];
      break;
    } else {
      result += Math.floor(check / arr[idx]);
      check -= Math.floor(check / arr[idx]) * arr[idx];
      idx++;
    }
  }

  return result;
}

function solution2(arr, M) {
  let result = Number.MAX_SAFE_INTEGER;

  function dfs(l, sum) {
    if (sum > M) return;
    if (l > result) return;
    if (sum === M) {
      result = Math.min(result, l);
    } else {
      for (let i = 0; i < arr.length; i++) {
        dfs(l + 1, sum + arr[i]);
      }
    }
  }
  dfs(0, 0);
  return result;
}

console.log(solution([1, 2, 5], 15));
console.log(solution([1, 3, 6], 15));
console.log(solution2([1, 2, 6], 15));
