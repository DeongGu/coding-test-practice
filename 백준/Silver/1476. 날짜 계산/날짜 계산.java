import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] ESM = br.readLine().split(" ");
		
		int E = Integer.parseInt(ESM[0]);
		int S = Integer.parseInt(ESM[1]);
		int M = Integer.parseInt(ESM[2]);
		
		int result = 0;
		
		while(true) {
		
			if(E == 1 && S == 1 && M == 1) {
				result++;
				break;
			}
			
			if(E - 1 == 0) {
				E = 15;
			}else {
				E--;
			}
			
			if(S - 1 == 0) {
				S = 28;
			}else {
				S--;
			}
			
			if(M - 1 == 0) {
				M = 19;
			}else {
				M--;
			}
			
			result++;
		}
		
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}