class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        // 정수배열
        int[] result = new int[2];
        
        // 분모
        int denom = denom1 * denom2;
        
        // 분자
        int numer = (numer1 * denom2) + (numer2 * denom1);
        
        // 최대공약수
        int divideNum = 1;
        
        if(denom > numer){
            
            for(int i = 1; i <= numer; i++){
                if(denom%i == 0 && numer % i == 0) divideNum = i;
            }
            
        }else{
            for(int i = 1; i <= denom; i++){
                if(denom%i == 0 && numer % i == 0) divideNum = i;
            }
        }
        
        result[0] = numer/divideNum; 
        result[1] = denom/divideNum;
        
        return result;
    }
}