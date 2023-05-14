function solution(str) {
  const obj = {};
  let result = "";

  str.split("").forEach((el, idx) => (obj[el] ? obj[el]++ : (obj[el] = 1)));

  Object.keys(obj).forEach((el) => {
    result += el;

    if (obj[el] !== 1) result += obj[el];
  });

  return result;
}

console.log(solution("KKHSSSSSSSE"));
