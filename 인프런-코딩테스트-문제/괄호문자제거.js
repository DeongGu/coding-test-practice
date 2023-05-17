function solution(str) {
  const stack = [];
  const result = [];

  for (let x of str) {
    if (x === "(") {
      stack.push("(");
    } else {
      if (stack.length === 0) result.push(x);
      if (x === ")") stack.pop();
    }
  }
  return result.join("");
}

console.log(solution("(A(BC)D)EF(G(H)(IJ)K)LM(N)"));
