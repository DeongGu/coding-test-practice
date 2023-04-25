function solution(todo_list, finished) {
    const result = [];
    
    finished.forEach((el,idx) => {
        if(!el) result.push(todo_list[idx]);
    });
    
    return result;
}