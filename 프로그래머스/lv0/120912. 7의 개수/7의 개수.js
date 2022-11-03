function solution(array) {
    const result = array.join("");
    return result.replace(/[^7]/g, "").length;
}