import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] result = new int[N];
		
		int num = 2;
		
		result[0] = 1;

		for(int i = 1; i < N; i++) {
			
			boolean check = true;
			
			while(true) {
				
				for(int j = 2; j * j <= num; j++) {
					
					if(num % j == 0) {
						num++;
						check = false;
						break;
					}
					
				}
				
				if(check) {
					result[i] = num++;
					break;
				}else {
					check = true;
				}
				
			}
			
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(result[i]).append(" ");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}