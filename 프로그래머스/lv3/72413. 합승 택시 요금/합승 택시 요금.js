function solution(n, s, a, b, fares) {
    const INF = Number.MAX_SAFE_INTEGER;

    const arr = Array.from({ length: n }, () => Array(n).fill(INF));

    for (let i = 0; i < n; i++) {
        arr[i][i] = 0;
    }

    for (const [x, y, w] of fares) {
        arr[x - 1][y - 1] = w;
        arr[y - 1][x - 1] = w;
    }

    for (let k = 0; k < n; k++) {
        for (let i = 0; i < n; i++) {
            for (let j = 0; j < n; j++) {
                if (arr[i][j] > arr[i][k] + arr[k][j]) {
                    arr[i][j] = arr[i][k] + arr[k][j];
                }
                // arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
            }
        }
    }

    let minFare = INF;

    for (let i = 0; i < n; i++) {
        const combinedFare = arr[s - 1][i] + arr[i][a - 1] + arr[i][b - 1];
        if (combinedFare < minFare) {
            minFare = combinedFare;
        }
    }

    return Math.min(minFare, arr[s - 1][a - 1] + arr[s - 1][b - 1]);
}