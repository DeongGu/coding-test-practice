function solution(maps) {
    const dx = [1, -1, 0, 0];
    const dy = [0, 0, 1, -1];
    const visited = new Array(maps.length).fill().map(() => new Array(maps[0].length).fill(false));
    const queue = [[0, 0, 1]];
    
    while (queue.length > 0) {
        const [x, y, count] = queue.shift();
        
        if (x === maps[0].length - 1 && y === maps.length - 1) {
            return count;
        }
        
        for (let i = 0; i < 4; i++) {
            const nx = x + dx[i];
            const ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < maps[0].length && ny < maps.length) {
                if (maps[ny][nx] === 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.push([nx, ny, count + 1]);
                }
            }
        }
    }
    
    return -1;
}