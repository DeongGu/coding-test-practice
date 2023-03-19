function solution(word) {

    const alpha = ["A","E","I","O","U"];
    const wordArr = [];
    const allArr = [];

    for(let i = 0; i < 5; i++){
        wordArr.push(alpha[i]);
        allArr.push(wordArr.join(""));
        if(wordArr.join("") === word) break;
        for(let j = 0; j < 5; j++){
            wordArr.push(alpha[j]);
            allArr.push(wordArr.join(""));
            if(wordArr.join("") === word) break;
            for(let k = 0; k < 5; k++){
                wordArr.push(alpha[k]);
                allArr.push(wordArr.join(""));
                if(wordArr.join("") === word) break;
                for(let l= 0; l < 5; l++){
                    wordArr.push(alpha[l]);
                    allArr.push(wordArr.join(""));
                    if(wordArr.join("") === word) break;
                    for(let m = 0; m < 5; m++){
                        wordArr.push(alpha[m]);
                        allArr.push(wordArr.join(""));
                        if(wordArr.join("") === word) break;
                        wordArr.pop();
                    }
                    wordArr.pop();
                }
                wordArr.pop();
            }
            wordArr.pop();
        }
        wordArr.pop();
    }

    return allArr.indexOf(word)+1;
}