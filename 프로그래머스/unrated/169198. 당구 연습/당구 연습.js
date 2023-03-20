function solution(m, n, startX, startY, balls) {
  const result = [];

  for (let i = 0; i < balls.length; i++) {
      
      if(startX === balls[i][0] && startY < balls[i][1]){
          const x1 = (-1) *balls[i][0];
          const distance1 = (startX - x1)**2 + (startY - balls[i][1])**2;
          
          const x2 = 2*m - balls[i][0];
          const distance2 = (startX - x2)**2 + (startY - balls[i][1])**2;
          
          const y1 = (-1) * balls[i][1];
          const distance3 = (startY - y1)**2;    
         
          result.push(Math.min(distance1, distance2, distance3));
          continue;
      }
      
      if(startY === balls[i][1] && startX > balls[i][0]){
          
          const y1 = 2*n - balls[i][1];
          const distance1 = (startX - balls[i][0])**2 + (startY - y1)**2;
          
          const y2 = (-1) * balls[i][1];
          const distance2 = (startX - balls[i][0])**2 + (startY - y2)**2;
          
          const x1 = 2*m - balls[i][0];
          const distance3 = (startX - x1)**2;
          
          result.push(Math.min(distance1, distance2, distance3));
          continue;
      }
    
      if(startY === balls[i][1] && startX < balls[i][0]){
          
          const y1 = 2*n - balls[i][1];
          const distance1 = (startX - balls[i][0])**2 + (startY - y1)**2;
          
          const y2 = (-1) * balls[i][1];
          const distance2 = (startX - balls[i][0])**2 + (startY - y2)**2;
          
          const x1 = (-1) *balls[i][0];
          const distance3 = (startX - x1)**2;
          
          result.push(Math.min(distance1, distance2, distance3));
          continue;
      }
      
      if(startX === balls[i][0] && startY > balls[i][1]){
          const x1 = (-1) *balls[i][0];
          const distance1 = (startX - x1)**2 + (startY - balls[i][1])**2;
          
          const x2 = 2*m - balls[i][0];
          const distance2 = (startX - x2)**2 + (startY - balls[i][1])**2;
          
          const y1 = 2*n - balls[i][1];
          const distance3 = (startY - y1)**2;    
         
          result.push(Math.min(distance1, distance2, distance3));
          continue;
      }
      
      
    const x1 = (-1) * balls[i][0];
    const distance1 = (startX - x1)**2 + (startY - balls[i][1])**2;
    
    const x2 = 2*m - balls[i][0];
    const distance2 = (startX - x2)**2 + (startY - balls[i][1])**2;
    
    const y1 = 2*n - balls[i][1];
    const distance3 = (startX - balls[i][0])**2 + (startY - y1)**2;
    
    const y2 = (-1) *balls[i][1];
    const distance4 = (startX - balls[i][0])**2 + (startY - y2)**2;
 
     result.push(Math.min(distance1,distance2, distance3, distance4));
  }

  return result;
}