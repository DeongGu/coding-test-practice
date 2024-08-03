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
        
        
        // 작은 수를 기준으로 1부터 본인까지 나눠 떨어지는 수까지 반복 진행
        // 분자, 분모가 둘 다 나눠 떨어져야함
        
        if(denom > numer){
            
            for(int i = 1; i <= numer; i++){
                if(denom%i == 0 && numer % i == 0) divideNum = i;
            }
            
        }else{
            for(int i = 1; i <= denom; i++){
                if(denom%i == 0 && numer % i == 0) divideNum = i;
            }
        }
        
        // 정수배열에 각각 할당

        result[0] = numer/divideNum; 
        result[1] = denom/divideNum;
        
        return result;
    }
}