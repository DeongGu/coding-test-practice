import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] arrStr = br.readLine().split(" ");
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        
        if (N == 1) {
           sb.append("YES").append("\n");
           sb.append(arr[0] - 1).append("\n");
           sb.append("1");
        }else{
            
            int d = arr[1] - arr[0];
            boolean check = true;
        
            for (int i = 1; i < N; i++) {
                if (arr[i] - arr[i - 1] != d) {
                    check = false;
                    break;
                }
            }

            if (check) {
                sb.append("YES").append("\n");
            
                for (int i = 0; i < N; i++) {
                    sb.append(arr[i] - (i + 1)).append(" ");
                }
                sb.append("\n");
            
                for (int i = 0; i < N; i++) {
                    sb.append(i + 1).append(" ");
                }
            } else {
                sb.append("NO");
            }
             
        }
      
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}