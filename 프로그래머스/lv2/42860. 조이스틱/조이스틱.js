function solution(name) {
  const alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  let result = 0;
  const charArr = name.split("");

  // Step 1: 상하 조작 횟수 계산
  charArr.forEach((el) => {
    const index = alpha.indexOf(el);
    result += Math.min(26 - index, index);
  });

  if(name.replace(/A/g,"").length === 0) return 0;

  let minMove = name.length - 1; 

  for (let i = 0; i < name.length; i++) {
    if (name[i] !== "A") {
      let nextNonA = i + 1;
      while (nextNonA < name.length && name[nextNonA] === "A") {
        nextNonA++;
      }

      const leftMove = i + name.length - nextNonA + Math.min(i, name.length - nextNonA);
      minMove = Math.min(minMove, leftMove);
    }
  }

  result += minMove;

  return result;
}