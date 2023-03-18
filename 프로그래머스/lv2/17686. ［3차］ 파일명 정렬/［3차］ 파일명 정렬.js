function solution(files) {
    
    return files.sort((a,b) => {
        
        if(a.split(/[0-9]/)[0].toUpperCase() > b.split(/[0-9]/)[0].toUpperCase()) return 1;
        
        if(a.split(/[0-9]/)[0].toUpperCase() < b.split(/[0-9]/)[0].toUpperCase()) return -1;
        
        if(a.split(/[0-9]/)[0].toUpperCase() === b.split(/[0-9]/)[0].toUppserCase) return 0;

     
        
        if(a.split(/[^0-9]/g).filter(el => el.length > 0).map(Number)[0] > b.split(/[^0-9]/g).filter(el => el.length > 0).map(Number)[0]) return 1;
        
        if(a.split(/[^0-9]/).filter(el => el.length > 0).map(Number)[0] < b.split(/[^0-9]/g).filter(el => el.length > 0).map(Number)[0]) return -1;
        
        if(a.split(/[^0-9]/g).filter(el => el.length > 0).map(Number)[0] === b.split(/[^0-9]/g).filter(el => el.length > 0).map(Number)[0]) return 0;
  
         });
}