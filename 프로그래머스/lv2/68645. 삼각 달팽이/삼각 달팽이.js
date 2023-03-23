function solution(n) {
    const arr = Array.from({length:n}).map(() => new Array(n).fill(0));
    
    //down, up, straight
    let state = "down";
    let up = 0;
    let down = 0;
    let straight = n-1;
    let nums = 1;
    let check = 0;
    
    for(let i = 0; i < n; i++){
        
        if(state === "down"){
            for(let j = down; j < n-check; j++){
                arr[j][check] = nums;
                nums++;
            }
            
            state = "straight";
            if(down === 0){
                down++;
            }else{
                down+=2;
            }
            check++;
            continue;
        }
        
        if(state === "straight"){
           for(let j = 1; j <= straight; j++){
               arr[n-check][check+j-1] = nums;
               nums++;
           }

            state = "up";
            straight-=3;
            continue;
        }
        
        
        if(state === "up"){
            
            for(let j = n - 2 - up; j > 2*up+1; j--){
               
                arr[j][j-up] = nums;
                nums++;
            }
            
            if(n-2-up === 2*up+1){
                arr[n-2-up][n-2-2*up] = nums;
                nums++;
            }
           
            state = "down";
            up++;
            continue;
        }
     
    }
    
    return arr.flat().filter((el) => el !== 0);
}