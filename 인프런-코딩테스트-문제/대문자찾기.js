function solution(str) {
  let result = 0;
  const newStr = str.toUpperCase();

  for (let i = 0; i < str.length; i++) {
    if (str[i] === newStr[i]) result++;
  }
  return result;
}

console.log(solution("KoreaTimeGood"));
