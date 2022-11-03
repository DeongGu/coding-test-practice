function solution(hp) {
    let count = 0;
    
    while(hp - 5 >= 0){
        hp -= 5;
        count++;
    }
    
    while(hp - 3 >= 0){
        hp -= 3;
        count++;
    }
    
    while(hp - 1 >= 0){
        hp -= 1;
        count++;
    }
    
    
    return count;
}