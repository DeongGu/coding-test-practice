function solution(arr) {
  return arr[0].length - arr[0].replace(/R/g, "").length;
}

console.log(solution(["COMPUTERPROGRAMMING", "R"]));
