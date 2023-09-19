function solution(n, s) {
    if (s < n) return [-1];
    
    const quotient = Math.floor(s / n);
    const rest = s % n; 

    const result = Array(n).fill(quotient);

    for (let i = 0; i < rest; i++) {
        result[n - i - 1]++;
    }

    return result;
}