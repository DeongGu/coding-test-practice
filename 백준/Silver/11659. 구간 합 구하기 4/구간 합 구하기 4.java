import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		String[] numbers = br.readLine().split(" ");

		int[] sum = new int[N];
		
		sum[0] = Integer.parseInt(numbers[0]);
		
		for(int i = 1; i < N; i++) {
			sum[i] = sum[i-1]+Integer.parseInt(numbers[i]);
		}

		for (int tc = 0; tc < M; tc++) {

			String[] ij = br.readLine().split(" ");

			int i = Integer.parseInt(ij[0])-1;
			int j = Integer.parseInt(ij[1])-1;

			int result = 0;
			
			if(i == 0) {
				result = sum[j];
			}else {
				result = sum[j] - sum[i-1];
			}
			
			sb.append(result).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}