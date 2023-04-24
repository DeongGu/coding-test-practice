const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    str = input[0];
    const newStr = input[0].toLowerCase();
    const result = [];
    
    for(let i = 0; i < str.length; i++){
        if(str[i] === newStr[i]){
            result.push(str[i].toUpperCase());
        }else{
            result.push(newStr[i]);
        }
    }
    
    console.log(result.join(""));
});