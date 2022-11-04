function solution(my_string) {
    const result = my_string.replace(/[^0-9]/gi," ").trim().split(" ").map((el)=>+el).filter((el)=> el !==0);
    
    let answer = 0;
    
    if(result.length === 0) {
        return 0
    }else{
        result.map((el)=> answer+= el);
        return answer;    
    }
    
    
}