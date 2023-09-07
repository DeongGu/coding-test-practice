function solution(orders, course) {
    const answer = [];
    
    function getCombination(arr, count){
        const result = [];
        if(count === 1) return arr.map((el) => [el]);
            arr.forEach((fixed, idx, ori) => {
                const rest = ori.slice(idx+1);
                const combinations = getCombination(rest, count-1);
                const attached = combinations.map((combination) => [fixed, ...combination].join(""));
                result.push(...attached);
               });

        return result;
    }
    
    const tmp = [];
    const all = {};
    course.forEach((el) => {
        orders.forEach((order) => {
            tmp.push(...getCombination(order.split("").sort(),el));    
        });
    });
    
    tmp.forEach((el) => all[el] ? all[el]++ : all[el] = 1);
    
    for (const [key, value] of Object.entries(all)) {
        if(value === 1) delete all[key];
    }
    
    course.forEach((el) => {
      const filtered = Object.entries(all).filter((element) => element[0].length === el);
     
        const num = filtered.map((arr) => arr[1]);
        const max = Math.max(...num);
    
        const filteredMax = filtered.filter((arr) => arr[1] === max);
        
        filteredMax.forEach((el) => answer.push(el[0]));
        
    })
    
   answer.sort();
    
   return answer;
}