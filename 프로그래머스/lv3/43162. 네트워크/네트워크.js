function solution(n, computers) {
    let result = 0;
    const visited = new Array(n).fill(false);

    function dfs(num) {
        visited[num] = true;
        for (let i = 0; i < n; i++) {
            if (computers[num][i] === 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    for (let i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs(i);
            result++;
        }
    }

    return result;
}