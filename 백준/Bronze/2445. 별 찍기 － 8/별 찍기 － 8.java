import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < N; i++) {
			String result = "";
			result+= "*".repeat(i+1);
			result+= " ".repeat(2*(N-1-i));
			result+= "*".repeat(i+1);
			
			sb.append(result).append("\n");
		}
		
		for(int i = N-1; i >=0; i--) {
			String result = "";
			result+= "*".repeat(i);
			result+= " ".repeat(2*(N-i));
			result+= "*".repeat(i);
			
			sb.append(result).append("\n");
		}
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}
}