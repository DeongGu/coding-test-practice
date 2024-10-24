import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] S = br.readLine().split("");
		
		String[] result = new String[S.length];
		
		String element = "";
		
		for(int i = S.length-1; i >= 0; i--) {
			element = S[i] + element;
			result[i] = element;
		}
		
		Arrays.sort(result);
		
		for(int i = 0; i < S.length; i++) {
			sb.append(result[i]).append("\n");
		}
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}