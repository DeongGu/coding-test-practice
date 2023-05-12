function solution(str) {
  let result = "";
  const newStr = str.toUpperCase();

  str
    .split("")
    .forEach((el, idx) =>
      el === newStr[idx]
        ? (result += el.toLowerCase())
        : (result += el.toUpperCase())
    );
  return result;
}

console.log(solution("StuDY"));
