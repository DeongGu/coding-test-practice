import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		while(true) {
			
			boolean check = false;
			
			for(int i = 2; i * i <= N/2; i++) {
				
				if(N % i == 0) {
					check = true;
					break;
				}
				
			}
			
			if(check) {				
				result = N;
				break;
			}
			
			N++;
		}

		sb.append(result);
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}