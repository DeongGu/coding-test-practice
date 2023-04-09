function solution(sequence, k) {

  let left = 0;
  let right = 0;
  let sum = sequence[0];
  let result = [];

  while (right < sequence.length) {
    if (sum < k) {
      right++;
      sum += sequence[right];
    } else if (sum > k) {
      sum -= sequence[left];
      left++;
    } else {
      result.push([left, right]);
      right++;
      sum += sequence[right];
    }
  }
    
    return result.sort((a,b) => (a[1] - a[0]) - (b[1] - b[0]))[0];
}