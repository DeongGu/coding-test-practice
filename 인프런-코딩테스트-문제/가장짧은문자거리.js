function solution(str) {
  const [s, t] = str.split(" ");
  const result = [];

  let idx = 1;

  for (let i = 0; i < s.length; i++) {
    const search = s.indexOf(t, i);

    if (Math.abs(i - search) > Math.abs(i - idx)) {
      result.push(Math.abs(i - idx));
    } else {
      result.push(Math.abs(i - search));
      idx = search;
    }
  }

  return result;
}

console.log(solution("teachermode e"));
