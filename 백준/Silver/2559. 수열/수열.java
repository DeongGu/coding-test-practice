import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] tc = br.readLine().split(" ");
		
		int N = Integer.parseInt(tc[0]);
		int K = Integer.parseInt(tc[1]);
		
		String[] arr = br.readLine().split(" ");
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		for(int i = 0; i < K; i++) {
			sum += Integer.parseInt(arr[i]);
		}
		
		for(int i = 0; i <= N-K; i++) {
			
			if(i != 0) {				
				sum -= Integer.parseInt(arr[i-1]);
				sum += Integer.parseInt(arr[i+K-1]);
			}
			
			max = Math.max(max, sum);
		}
		
		sb.append(max);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}