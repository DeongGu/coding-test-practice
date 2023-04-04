function solution(priorities, location) {
    const newPriorities = new Array(priorities.length).fill().map((_,idx) => [priorities[idx],idx] );
    const result = [];
    let answer = 0;

    while(priorities.length !== 0){
        let first = priorities.shift();
        let newFirst = newPriorities.shift();
        let max = Math.max(...priorities);

        if(first < max){
            newPriorities.push(newFirst);
            priorities.push(first);
        }else{
            result.push(newFirst);
        }
    }

    result.forEach((el,idx) => {
        if(el[1] === location){
            answer = idx+1;
        };
    })

    return answer;
}