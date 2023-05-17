function solution1(board, moves) {
  const stack = [];
  let result = 0;

  for (let i = 0; i < moves.length; i++) {
    const move = moves[i] - 1;

    for (let j = 0; j < board.length; j++) {
      const doll = board[j][move];

      if (doll !== 0) {
        if (stack.length > 0 && stack[stack.length - 1] === doll) {
          stack.pop();
          result += 2;
        } else {
          stack.push(doll);
        }

        board[j][move] = 0;
        break;
      }
    }
  }

  return result;
}

function solution2(board, moves) {
  const stack = [];
  let result = 0;

  moves.forEach((el) => {
    for (let i = 0; i < board.length; i++) {
      let tmp = board[i][el - 1];
      if (tmp !== 0) {
        if (stack.length !== 0 && tmp === stack[stack.length - 1]) {
          stack.pop();
          result += 2;
        } else {
          stack.push(tmp);
        }
        board[i][el - 1] = 0;
        break;
      }
    }
  });

  return result;
}

const array1 = [
  [0, 0, 0, 0, 0],
  [0, 0, 1, 0, 3],
  [0, 2, 5, 0, 1],
  [4, 2, 4, 4, 2],
  [3, 5, 1, 3, 1],
];
const array2 = [1, 5, 3, 5, 1, 2, 1, 4];

const array3 = [
  [0, 0, 0, 0, 0],
  [0, 0, 1, 0, 3],
  [0, 2, 5, 0, 1],
  [4, 2, 4, 4, 2],
  [3, 5, 1, 3, 1],
];
const array4 = [1, 5, 3, 5, 1, 2, 1, 4];
console.log(solution1(array1, array2));
console.log(solution2(array3, array4));
