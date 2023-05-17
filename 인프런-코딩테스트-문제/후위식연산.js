function solution(str) {
  const stack = [];

  for (let x of str) {
    if (x === "+") {
      stack.push(Number(stack.pop()) + Number(stack.pop()));
      continue;
    }
    if (x === "-") {
      const first = +stack.pop();
      const second = +stack.pop();
      stack.push(second - first);
      continue;
    }
    if (x === "*") {
      stack.push(Number(stack.pop()) * Number(stack.pop()));
      continue;
    }
    if (x === "/") {
      const first = +stack.pop();
      const second = +stack.pop();
      stack.push(second / first);
      continue;
    }

    stack.push(x);
  }
  return stack[0];
}

function solution2(str) {
  const stack = [];
  for (let x of str) {
    if (!isNaN(x)) stack.push(+x);
    else {
      let rt = stack.pop();
      let lt = stack.pop();
      if (x === "+") stack.push(lt + rt);
      else if (x === "-") stack.push(lt - rt);
      else if (x === "*") stack.push(lt * rt);
      else if (x === "/") stack.push(lt / rt);
    }
  }

  return stack[0];
}
console.log(solution("352+*9-"));
console.log(solution("63/"));

console.log(solution2("352+*9-"));
console.log(solution2("63/"));
