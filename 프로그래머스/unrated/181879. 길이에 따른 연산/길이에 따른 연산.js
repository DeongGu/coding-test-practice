function solution(num_list) {
    if(num_list.length >= 11){
        let result = 0;
        num_list.forEach((el) => result+= el);
        return result;
    }else{
        let result = 1;
        num_list.forEach((el) => result*= el);
        return result;
    }
}