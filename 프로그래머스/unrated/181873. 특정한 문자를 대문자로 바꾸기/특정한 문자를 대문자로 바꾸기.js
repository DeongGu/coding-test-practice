function solution(my_string, alp) {
    const regex = new RegExp(alp, 'g');
    const newStr = my_string.replace(regex,alp.toUpperCase());
    return newStr;
}