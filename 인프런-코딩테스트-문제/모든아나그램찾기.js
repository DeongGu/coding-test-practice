function solution(str1, str2) {
  let result = 0;

  const sH2 = new Map();

  for (let x of str2) {
    if (sH2.has(x)) {
      sH2.set(x, sH2.get(x) + 1);
    } else {
      sH2.set(x, 1);
    }
  }

  for (let i = 0; i <= str1.length - str2.length; i++) {
    const newStr1 = str1.slice(i, i + str2.length);
    const sH1 = new Map();
    let check = true;

    for (let x of newStr1) {
      if (sH1.has(x)) {
        sH1.set(x, sH1.get(x) + 1);
      } else {
        sH1.set(x, 1);
      }
    }

    for (let x of str2) {
      if (sH1.get(x) !== sH2.get(x)) {
        check = false;
        break;
      }
    }

    if (check) result++;
  }

  return result;
}

console.log(solution("bacaAacba", "abc"));
