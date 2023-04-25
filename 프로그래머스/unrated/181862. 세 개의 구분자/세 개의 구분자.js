function solution(myStr) {
    const str = myStr.split(/[abc]/g).filter((el) => el !== "");
    
    return str.length === 0 ? ["EMPTY"] : str;
}