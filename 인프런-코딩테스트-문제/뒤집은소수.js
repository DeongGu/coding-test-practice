function isPrime(num) {
  if (num === 1) return false;
  for (let i = 2; i * i < num; i++) {
    if (num % i === 0) return false;
  }
  return true;
}

function solution(arr) {
  const result = [];

  for (let x of arr) {
    const newX = parseInt(x.toString().split("").reverse().join(""));
    if (isPrime(newX)) result.push(newX);
  }

  return result;
}

console.log(solution([32, 55, 62, 20, 250, 370, 200, 30, 100]));
