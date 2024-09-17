import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String result = "";
			
			if(i == N-1) {
				result += "*".repeat(2*N-1);
				sb.append(result);
			}else {
				
				if(i == 0) {
					result += " ".repeat(N-1-i);
					result += "*";
				}else {
					result += " ".repeat(N-1-i);
					result += "*";
					result += " ".repeat(2*i-1);
					result += "*";
				}
				
				sb.append(result).append("\n");
			}
			
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}