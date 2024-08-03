import java.util.Scanner;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        StringBuilder sb = new StringBuilder(5);
        sb.append("a = ").append(a).append("\n").append("b = ").append(b);
        
        bw.write(sb.toString());
        bw.close();
    }
}