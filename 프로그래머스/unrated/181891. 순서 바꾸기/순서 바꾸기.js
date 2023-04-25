function solution(num_list, n) {
   const front = num_list.splice(n);
    
    return front.concat(num_list);
}