function solution(a, b) {
    const first = Number(String(a)+String(b));
    const second = Number(String(b)+String(a));
    
    return first > second ? first : second;
}