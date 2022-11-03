function solution(strlist) {
    
    const lengthlist = [];
    strlist.forEach(el=> lengthlist.push(el.length));
    return lengthlist;
}