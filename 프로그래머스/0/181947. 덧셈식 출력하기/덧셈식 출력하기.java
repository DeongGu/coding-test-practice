import java.util.Scanner;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(5);
        
        sb.append(a).append(" + ").append(b).append(" = ").append(a+b);
        
        bw.write(sb.toString());
        
        bw.flush();
        bw.close();
    }
}