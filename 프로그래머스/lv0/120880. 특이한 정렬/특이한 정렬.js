function solution(numlist, n) {
    const newlist = numlist.map((el)=> el-n).sort((a,b)=>b-a).sort((a,b)=>Math.abs(a)-Math.abs(b));
    
    
    return newlist.map((el)=> el+n);

}