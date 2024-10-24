import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String result = br.readLine();
		sb.append(result.length());

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}
}