import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		String result = "";
		
		for(int i = 0; i < N; i++) {
			result+= "*";
			sb.append(result).append("\n");
		}
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}