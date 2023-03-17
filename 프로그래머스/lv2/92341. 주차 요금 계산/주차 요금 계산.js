function solution(fees, records) {
    
    const inRecord = {};
    const Record = {};
    const result = [];
    
    for(let i = 0; i < records.length; i++){
        const [time, carNumber, action] = records[i].split(" ");
        
        if(action === "IN"){
            inRecord[carNumber] = new Date(`2023-03-17 ${time}:00`);
            Record[carNumber] ? null : Record[carNumber] = 0;
            continue;
        }
        
        if(action === "OUT"){
            const outRecord = new Date(`2023-03-17 ${time}:00`);
            Record[carNumber] +=  (outRecord.getTime() - inRecord[carNumber].getTime())/(60 * 1000);
            
            inRecord[carNumber] = 0;
        }
    }
    
    
    Object.values(inRecord).map((el,idx) => {        
        if(el !== 0){
            const outRecord = new Date("2023-03-17 23:59:00");
            Record[Object.keys(inRecord)[idx]] += (outRecord.getTime() - inRecord[Object.keys(inRecord)[idx]].getTime())/(60*1000);
        }
    })
    
    
   Object.keys(Record).sort((a,b) => a - b).map((el,idx) => {
       const price = fees[1] + Math.ceil((Record[el] - fees[0])/fees[2])*fees[3];
       
       if(Record[el] <= fees[0]){
         result.push(fees[1]);  
       } else{
           result.push(price);
       }
   });
    
    return result;
}

