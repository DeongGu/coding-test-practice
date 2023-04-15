function calculate(a, b, op) {
  switch(op) {
    case '+': return a + b;
    case '-': return a - b;
    case '*': return a * b;
  }
}

function dfs(ops, priorities, expression) {
  if (ops.length === priorities.length) { // 모든 연산자에 우선순위가 배정됨
    let tokens = expression.split(/(\D)/); // 피연산자와 연산자를 분리
    for (let op of priorities) {
      for (let i = 1; i < tokens.length; i += 2) {
        if (tokens[i] === op) {
          let a = parseInt(tokens[i - 1]);
          let b = parseInt(tokens[i + 1]);
          tokens.splice(i - 1, 3, calculate(a, b, op)); // 계산 결과로 대체
          i -= 2; // 인덱스 조정
        }
      }
    }
    return Math.abs(tokens[0]); // 최종 결과의 절댓값 반환
  }

  let maxVal = 0;
  for (let i = 0; i < ops.length; i++) {
    if (priorities.includes(ops[i])) continue; // 이미 우선순위 배정된 연산자는 건너뜀
    priorities.push(ops[i]);
    let val = dfs(ops, priorities, expression);
    maxVal = Math.max(maxVal, val);
    priorities.pop();
  }
  return maxVal;
}

function solution(expression) {
  let ops = ['+', '-', '*'];
  let maxVal = dfs(ops, [], expression);
  return maxVal;
}