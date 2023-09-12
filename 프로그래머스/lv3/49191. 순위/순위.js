function solution(n, results) {
    const result = Array.from({length: n}, () => new Array(n).fill(false));

    for(const [win, lose] of results){
        result[win-1][lose-1] = true;
    }
    
     for (let k = 0; k < n; k++) {
        for (let i = 0; i < n; i++) {
            for (let j = 0; j < n; j++) {
                if (result[i][k] && result[k][j]) {
                    result[i][j] = true;
                }
            }
        }
    }

    let answer = 0;
    for (let i = 0; i < n; i++) {
        let count = 0;
        for (let j = 0; j < n; j++) {
            if (result[i][j] || result[j][i]) {
                count++;
            }
        }
 
        if (count === n - 1) {
            answer++;
        }
    }

    return answer;
}