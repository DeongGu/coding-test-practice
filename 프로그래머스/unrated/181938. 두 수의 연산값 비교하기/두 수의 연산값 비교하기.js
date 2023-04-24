function solution(a, b) {
    const first = Number(String(a) + String(b));
    const second = 2 * a * b;
    
    return first > second ? first : second; 
}