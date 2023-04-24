function solution(num_list) {
    let first = "";
    let second = "";
    
    num_list.forEach((el) => {
        if(el % 2 == 0){
            first+= String(el);
        }else{
            second+= String(el);
        }
    })
    
    return Number(first)+Number(second);
}