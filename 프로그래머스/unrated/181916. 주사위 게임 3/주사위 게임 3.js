function solution(a, b, c, d) {
    const arr = [a,b,c,d].sort((x,y) => x - y);
    
    if(a === b && b === c && c === d){
        return 1111 * a;
    }
    
    if(arr[0] === arr[1] && arr[1] === arr[2]){
        return (10 * arr[0] + arr[3])**2;
    }
    
    if(arr[1] === arr[2] && arr[2] === arr[3]){
        return (10 * arr[1] + arr[0])**2;
    }
    
    if(arr[0] === arr[1] && arr[2] === arr[3]){
        return (arr[0]+arr[2]) * Math.abs(arr[0]-arr[2]);
    }
    
    if(arr[0] === arr[1]){
        return arr[2]*arr[3];
    }
    
    if(arr[1] === arr[2]){
        return arr[0]*arr[3];
    }
    
    if(arr[2] === arr[3]){
        return arr[0]*arr[1];
    }
    
    return Math.min(...arr);
}