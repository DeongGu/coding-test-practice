import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		String[] intArr = br.readLine().split(" ");
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			max = Math.max(max, Integer.parseInt(intArr[i]));
			min = Math.min(min, Integer.parseInt(intArr[i]));
		}
		
		sb.append(min).append(" ").append(max);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}