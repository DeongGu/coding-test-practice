function solution(today, terms, privacies) {
    const result = [];
    const newTerms = {};
    const toDay = new Date(today);
    terms.map(el => {
        const element = el.split(" ");
        newTerms[element[0]] = parseInt(element[1]);
    });
   
    privacies.map((el,idx) => {
        const element = el.split(" ");
        const date = new Date(element[0]);
        date.setMonth(date.getMonth()+newTerms[element[1]]);
        
        if(toDay >= date) result.push(idx+1);
    })
    
    return result;
}