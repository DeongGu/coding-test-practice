function solution(topping) {
  let result = 0;
  const obj = {};
  let check1 = 0;
  let check2 = 0;
  const checkArr = new Array(topping.length).fill(0);
  

  topping.forEach((el, idx) => {
    if (obj[el]) {
      obj[el]++;
      checkArr[idx] = check1;
    } else {
      obj[el] = 1;
      check1++;
      checkArr[idx] = check1;
    }
  });

const keyCount = Object.keys(obj).length;
    
  topping.forEach((el, idx) => {
    obj[el]--;

    if (obj[el] === 0) {
      check2++;
    } 
    if (checkArr[idx] === keyCount - check2) {
        result++;
     }
  });

  return result;
}
