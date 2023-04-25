function solution(n, slicer, num_list) {
    if(n === 1){
        return num_list.slice(0,slicer[1]+1);
    }
    if(n === 2){
        return num_list.slice(slicer[0]);
    }
    if(n === 3){
        return num_list.slice(slicer[0],slicer[1]+1);
    }
    if(n === 4){  
        const newList = num_list.slice(slicer[0],slicer[1]+1);
        const result = [];
        for(let i = 0; i < newList.length; i+=slicer[2]){
            result.push(newList[i]);
        }
        
        return result;
    }
    
}