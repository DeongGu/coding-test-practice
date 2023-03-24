function solution(park, routes) {
    let y = 0;
    let x = 0;
    
    for(let i = 0; i < park.length; i++){
        const index = park[i].indexOf("S");
        if(index !== -1){
            x = index;
            y = i;
        }
    }
    
    for(let i = 0; i < routes.length; i++){
    
            const route = routes[i].split(" ");
            
            if(route[0] === "W"){
                let check = 0;
                for(let j = 1; j <= +route[1]; j++){
                    if(x-j < 0) break; 
                    if(park[y][x-j] === 'X') break;
                    check++;
                }
                if(check === +route[1]) x-= +route[1];
            }
            if(route[0] === "E"){
                let check = 0;
                for(let j = 1; j <= +route[1]; j++){
                    if(x+j > park[0].length-1) break;
                    if(park[y][x+j] === 'X') break;
                    check++;
                }
                if(check === +route[1]) x+= +route[1];
            }
            if(route[0] === "S"){
                let check = 0;
                for(let j = 1; j <= +route[1]; j++){
                    if(y+j > park.length-1) break;
                    if(park[y+j][x] === 'X') break;
                    check++;
                }
                if(check === +route[1]) y+= +route[1];
            }
        
        if(route[0] === "N"){
                let check = 0;
                for(let j = 1; j <= +route[1]; j++){
                    if(y-j < 0) break;
                    if(park[y-j][x] === 'X') break;
                    check++;
                }
                if(check === +route[1]) y-= +route[1];
            }
        }
    
    
    
    return [y,x];
    
}