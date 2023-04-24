function solution(arr, queries) {
    const result = [];
    
    for(let i = 0; i < queries.length; i++){
        const newArr = arr.slice(queries[i][0],queries[i][1]+1);
        
        const resultArr = newArr.filter((el) => el > queries[i][2]);

        if(resultArr.length === 0){
            result.push(-1);
        }else{
            result.push(Math.min(...resultArr));   
        }
    }
    
    return result;
}