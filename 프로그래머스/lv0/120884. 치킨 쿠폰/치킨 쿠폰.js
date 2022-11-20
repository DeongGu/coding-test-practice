function solution(chicken) {
    
    let coupon = chicken;
    
    let result = Math.floor(coupon/10); 
    
    coupon = Math.floor(coupon/10) + Math.floor(coupon%10);
    
    while(coupon >= 10){
        
        result += Math.floor(coupon/10); 
        
        coupon = Math.floor(coupon/10) + Math.floor(coupon%10);
         
    }
    
    return result;
    
}
