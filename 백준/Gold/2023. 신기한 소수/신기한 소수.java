import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

	
		dfs(N, 2);
        dfs(N, 3);
        dfs(N, 5);
        dfs(N, 7);
		
		
        for(int result : list) {
        	sb.append(result).append("\n");
        }
        
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}

	
	static void dfs(int l, int num) {
		
		if(l == 1) {
			list.add(num);
		}
		
		
		for(int i = 1; i <= 9; i++) {
			
			int nn = Integer.parseInt(num + Integer.toString(i));
			
			boolean check = true;
			
			for(int j = 2; j < nn; j++) {
				
				if(nn % j == 0) {
					check = false;
					break;
				}
			}
			
			if(check) {
				dfs(l-1, nn);
			}
			
		}
	
		
	}
	
}