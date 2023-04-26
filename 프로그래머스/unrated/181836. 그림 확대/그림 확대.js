function solution(picture, k) {
    const result = [];
    
    for(let i = 0; i < picture.length; i++){
        let str = ""
        for(let j = 0; j < picture[0].length; j++){
            str += picture[i][j].repeat(k);
        }
        
        for(let l = 0; l < k; l++){
            result.push(str);    
        }
    }
    
    return result;
}