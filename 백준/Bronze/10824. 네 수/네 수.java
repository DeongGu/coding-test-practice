import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] ABCD = br.readLine().split(" ");
		
		long AB = Long.parseLong(ABCD[0]+ABCD[1]);
		long CD = Long.parseLong(ABCD[2]+ABCD[3]);
		
		sb.append(AB + CD);
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}