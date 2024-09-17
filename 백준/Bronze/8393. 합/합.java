import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int result = (n*(1+n))/2;
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}