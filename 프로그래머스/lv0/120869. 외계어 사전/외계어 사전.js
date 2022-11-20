function solution(spell, dic) {
    
    const answer = [];
    
    dic = dic.filter((el) => el.length === spell.length);

    const newDic = dic.map((el) => {
        let result = el;
        spell.map((x) => {
            const regrex = new RegExp(x);
            result = result.replace(regrex , "");
        })
         answer.push(result);
    })
    
    return answer.filter((el) => el === "").length > 0 ? 1 : 2;
}