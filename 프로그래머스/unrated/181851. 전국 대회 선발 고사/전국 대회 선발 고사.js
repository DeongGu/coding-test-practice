function solution(rank, attendance) {
    const result = [];
    
    attendance.forEach((el,idx) => {
        if(el) result.push([rank[idx],idx]);
    });
    
    result.sort((a,b) => a[0] - b[0]);
    return 10000*result[0][1] + 100*result[1][1] + result[2][1];
}