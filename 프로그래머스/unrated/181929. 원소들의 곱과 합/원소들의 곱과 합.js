function solution(num_list) {
    let first = 0;
    let second = 1;
    
    num_list.forEach((el) => {
        first+= el;
        second*= el;
    });
    
    return first**2 > second ? 1 : 0;
}