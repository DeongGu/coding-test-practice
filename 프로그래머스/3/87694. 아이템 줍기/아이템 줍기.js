function solution(rectangle, characterX, characterY, itemX, itemY) {
    const n = 102;
    const matrix = Array.from({ length: n }, () => Array(n).fill(0));

    rectangle.forEach(([x1, y1, x2, y2]) => {
        for (let i = x1 * 2; i <= x2 * 2; i++) {
            for (let j = y1 * 2; j <= y2 * 2; j++) {
                matrix[j][i] = 1;
            }
        }
    });

    rectangle.forEach(([x1, y1, x2, y2]) => {
        for (let i = x1 * 2 + 1; i < x2 * 2; i++) {
            for (let j = y1 * 2 + 1; j < y2 * 2; j++) {
                matrix[j][i] = 0;
            }
        }
    });

    const visited = Array.from({ length: n }, () => Array(n).fill(false));
    const queue = [[characterX * 2, characterY * 2, 0]];
    const dx = [1, 0, -1, 0];
    const dy = [0, 1, 0, -1];

    visited[characterY * 2][characterX * 2] = true;

    while (queue.length) {
        const [x, y, dist] = queue.shift();

        if (x === itemX * 2 && y === itemY * 2) {
            return dist / 2;
        }

        for (let i = 0; i < 4; i++) {
            const nx = x + dx[i];
            const ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (!visited[ny][nx] && matrix[ny][nx] === 1) {
                    visited[ny][nx] = true;
                    queue.push([nx, ny, dist + 1]);
                }
            }
        }
    }

    return 0;
}
