function solution1(N, str) {
  const obj = {};

  str.split("").forEach((el, idx) => (obj[el] ? obj[el]++ : (obj[el] = 1)));

  return Object.keys(obj)[
    Object.values(obj).indexOf(Math.max(...Object.values(obj)))
  ];
}

function solution2(N, str) {
  let sH = new Map();
  let result = "";

  for (let x of str) {
    if (sH.has(x)) {
      sH.set(x, sH.get(x) + 1);
    } else {
      sH.set(x, 1);
    }
  }

  let max = Number.MIN_SAFE_INTEGER;
  for (let [k, v] of sH) {
    if (max < v) {
      max = v;
      result = k;
    }
  }

  return result;
}

console.log(solution1(15, "BACBACCACCBDEDE"));
console.log(solution2(15, "BACBACCACCBDEDE"));
