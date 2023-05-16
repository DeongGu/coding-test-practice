function solution1(str1, str2) {
  const obj1 = {};
  const obj2 = {};

  str1.split("").forEach((el) => (obj1[el] ? obj1[el]++ : (obj1[el] = 1)));
  str2.split("").forEach((el) => (obj2[el] ? obj2[el]++ : (obj2[el] = 1)));

  const result1 = Object.keys(obj1).filter(
    (el) => !Object.keys(obj2).includes(el)
  );
  const result2 = Object.keys(obj2).filter(
    (el) => !Object.keys(obj1).includes(el)
  );

  return result1.length === result2.length ? "YES" : "NO";
}

function solution2(str1, str2) {
  const sH1 = new Map();
  const sH2 = new Map();

  let result = "YES";

  for (let x of str1) {
    if (sH1.has(x)) {
      sH1.set(x, sH1.get(x) + 1);
    } else {
      sH1.set(x, 1);
    }
  }
  for (let x of str2) {
    if (sH2.has(x)) {
      sH2.set(x, sH2.get(x) + 1);
    } else {
      sH2.set(x, 1);
    }
  }

  for (let x of str1) {
    if (sH1.get(x) !== sH2.get(x) || sH1.size !== sH2.size) {
      return "NO";
    }
  }

  return result;
}

console.log(solution1("AbaAeCe", "baeeACA"));
console.log(solution2("AbaAeCe", "baeeACA"));
console.log(solution2("abaCC", "Caaab"));
