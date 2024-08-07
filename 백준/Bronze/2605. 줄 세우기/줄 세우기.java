import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> list = new ArrayList<>();
        
        int T = Integer.parseInt(br.readLine());
        
        String[] order = br.readLine().split(" ");
        
        for(int i = 0; i < order.length; i++) {
            int position = Integer.parseInt(order[i]);
            list.add(list.size() - position, i + 1);
        }
        
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
    }
}