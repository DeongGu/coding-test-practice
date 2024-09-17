import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String result = "";
			result += " ".repeat(i);
			result += "*".repeat(2*(N-i)-1);

			sb.append(result).append("\n");
		}

		for (int i = 1; i < N; i++) {
			String result = "";
			result += " ".repeat(N-1-i);
			result += "*".repeat(2*i+1);

			sb.append(result).append("\n");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}
}