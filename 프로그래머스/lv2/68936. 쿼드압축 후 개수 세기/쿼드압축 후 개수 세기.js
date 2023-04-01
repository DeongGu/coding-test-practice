function solution(arr) {
  const answer = [0, 0];
  
  const compress = (n, x, y) => {
    if (n === 1) {
      answer[arr[x][y]]++;
      return;
    }

    let same = true;
    for (let i = x; i < x + n; i++) {
      for (let j = y; j < y + n; j++) {
        if (arr[i][j] !== arr[x][y]) {
          same = false;
          break;
        }
      }
      if (!same) break;
    }

    if (same) {
      answer[arr[x][y]]++;
    } else {
      const half = n / 2;
      compress(half, x, y);
      compress(half, x, y + half);
      compress(half, x + half, y);
      compress(half, x + half, y + half);
    }
  }

  compress(arr.length, 0, 0);
  return answer;
}