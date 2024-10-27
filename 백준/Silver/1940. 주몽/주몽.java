import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		String[] in = br.readLine().split(" ");
		
		int[] arr = new int[N];
		
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in[i]);
		}
		
		Arrays.sort(arr);
		
		int prev = 0;
		int next = N - 1;
		
		
		while(prev < next) {
			
			long sum = arr[prev] + arr[next]; 
			
			if(sum == M) {
				result++;
				prev++;
				next--;
			}else if(sum < M) {
				prev++;
			}else {
				next--;
			}
			
		}
		
		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}
}