import java.util.Scanner;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
        
        if(n%2==0){
            sb.append(n).append(" is even");
        }else{
            sb.append(n).append(" is odd");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}