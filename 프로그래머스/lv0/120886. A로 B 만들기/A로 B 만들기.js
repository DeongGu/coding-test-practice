function solution(before, after) {
    const bf = before.split("");
    const af = after.split("");
    
    return JSON.stringify(bf.sort()) === JSON.stringify(af.sort()) ? 1 : 0;
}