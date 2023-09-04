function solution(prices) {
    
    const n = prices.length;
    const result = new Array(n).fill(0);
    const stack = [];
    
    for (let i = 0; i < n; i++) {
        while (stack.length > 0 && prices[i] < prices[stack[stack.length - 1]]) {
            const j = stack.pop();
            result[j] = i - j;
        }
        stack.push(i);
    }

    while (stack.length > 0) {
        const j = stack.pop();
        result[j] = n - 1 - j;
    }
    
    return result;
}