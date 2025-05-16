function solution(triangle) {
    const n = triangle.length;
    const memo = new Array(n).fill(0);

    for (let i = n - 1; i >= 0; i--) {
        for (let j = 0; j <= i; j++) {
            if (i === n - 1) {
                memo[j] = triangle[i][j];
            } else {
                memo[j] = Math.max(memo[j], memo[j + 1]) + triangle[i][j];
            }
        }
    }

    return memo[0];
}