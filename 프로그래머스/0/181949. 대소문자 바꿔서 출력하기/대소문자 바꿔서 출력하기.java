import java.util.Scanner;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = sc.next();
        StringBuilder sb = new StringBuilder(a.length());
        String[] s = a.split("");
        
        for(int i = 0; i < a.length(); i++){
            if(s[i] != s[i].toUpperCase()){
                sb.append(s[i].toUpperCase());
            }else{
                sb.append(s[i].toLowerCase());
            }
        }
        
        bw.write(sb.toString());
        bw.close();
        
    }
}