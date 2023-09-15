function solution(begin, target, words) {
    if (!words.includes(target)) return 0;
    
    const n = begin.length;
    const visited = new Set();
    
    function dfs(word) {
        if (word === target) {
            return;
        }

        for (let i = 0; i < words.length; i++) {
            const nextWord = words[i];
            if (!visited.has(nextWord) && sameLengthMatchOneChar(word, nextWord)) {
                visited.add(nextWord);
                dfs(nextWord);
            }
        }
    }
    
    dfs(begin);
    
    return visited.size;
}

function sameLengthMatchOneChar(first, second) {
    let difference = 0;
    const length = first.length;
    
    for (let i = 0; i < length; i++) {
        if (first[i] !== second[i]) difference++;
    }
    
    return difference === 1;
}