function solution1(str) {
  const obj = { "(": 1, ")": -1 };
  let check = 0;
  for (let x of str) {
    if (check < 0) return "NO";
    check += obj[x];
  }

  if (check !== 0) return "NO";
  return "YES";
}

function solution2(str) {
  const stack = [];

  for (let x of str) {
    if (x === "(") {
      stack.push(x);
    } else {
      if (stack[stack.length - 1] === "(") stack.pop();
      else return "NO";
    }
  }

  return stack.length === 0 ? "YES" : "NO";
}

function solution3(str) {
  const stack = [];

  for (let x of str) {
    if (x === "(") {
      stack.push(x);
    } else {
      if (stack.length === 0) return "NO";
      stack.pop();
    }
  }

  return stack.length === 0 ? "YES" : "NO";
}

console.log(solution1("(()(()))(()"));
console.log(solution2("(()(()))(()"));
console.log(solution3("(()(()))()"));
