function solution(maps) {
    const dr = [1, -1, 0, 0];
    const dc = [0, 0, 1, -1];
    
    const n = maps.length;
    const m = maps[0].length;
    
    const visited = Array.from({length: n}, () => Array.from({length: m}, () => false));
    const queue = [[0, 0, 1]];
    
    while (queue.length > 0) {
        const [r, c, count] = queue.shift();
        
        if (r === n - 1 && c === m - 1) {
            return count;
        }
        
        for (let i = 0; i < 4; i++) {
            const nr = r + dr[i];
            const nc = c + dc[i];
            
            if (nr >= 0 && nc >= 0 && nr < n && nc < m && maps[nr][nc] === 1 && !visited[nr][nc]) {
                visited[nr][nc] = true;
                queue.push([nr, nc, count + 1]);
            }
        }
    }
    
    return -1;
}