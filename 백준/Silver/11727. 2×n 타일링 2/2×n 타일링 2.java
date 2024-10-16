import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		long result = 1;
		
		for(int i = 1; i <= n; i++) {
			
			if(i % 2 == 0) {
				result = (result * 2 + 1) % 10007;
			}else {
				result = (result * 2 - 1) % 10007;
			}
		}
		
		sb.append(result).append("\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}