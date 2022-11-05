function solution(sides) {
    let result = 0;
    sides.sort((a,b)=>b-a);
    
    return 2*sides[1]-1;
}