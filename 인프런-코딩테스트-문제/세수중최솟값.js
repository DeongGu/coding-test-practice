function solution(a, b, c) {
  let result = 0;

  if (a > b) result = b;
  else result = a;

  if (result > c) result = c;

  return result;
}

console.log(solution(4, 6, 2));

//입력값의 형태(타입)에 따라 split, sort, Math.min 등의 메서드 사용
//예시) 배열의 경우, for문 + if 문으로 풀이가능
