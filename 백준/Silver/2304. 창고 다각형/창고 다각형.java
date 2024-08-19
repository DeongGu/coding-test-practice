import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		int maxHeight = 0;
		int maxHeightIdx = 0;
		
		int[] storage = new int[1001];
		
		int result = 0;
		
		for(int c = 0; c < N; c++) {
			
			String[] LH = br.readLine().split(" ");
			
			int L = Integer.parseInt(LH[0]);
			int H = Integer.parseInt(LH[1]);
			
			storage[L] = H;
			
			if(Math.max(maxHeight, H) == H) {
				maxHeight = H;
				maxHeightIdx = L;
			}
			
		}
		
		int currentHeight = 0;
		
		for(int i = 1; i <= maxHeightIdx; i++) {
		
			result += currentHeight;
			
			if(currentHeight < storage[i]) {
				currentHeight = storage[i];
			}
			
		}
		
		currentHeight = 0;
		
		for(int i = storage.length-1; i >= maxHeightIdx-1; i--) {
			
			result += currentHeight;
			
			if(currentHeight < storage[i]) {
				currentHeight = storage[i];
			}
			
		}
		
		sb.append(result);
	

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}