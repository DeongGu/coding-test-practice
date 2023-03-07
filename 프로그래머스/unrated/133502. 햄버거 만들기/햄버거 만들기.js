function solution(ingredient) {
    
   let answer = 0;
   const arr = [];
   ingredient.map((el,idx) => {
       arr.push(el);
       
       if(arr.length >= 4){
           if(arr.slice(arr.length-4, arr.length).join("") === "1231"){
               arr.splice(arr.length-4, arr.length);
               answer+=1;
           }       
       }
   })
    
    return answer;
}