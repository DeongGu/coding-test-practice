import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		
		int result = 0;
		int check = 0;
		
		for(int i = 0; i < 8; i++) {
			
			String[] status = br.readLine().split("");
			
			for(int c = check; c < 8; c+=2) {
				if(status[c].equals("F")) result++;
			}
			
			if(check == 1) {
				check = 0;
			}else {
				check = 1;
			}
			
		}
		
		sb.append(result);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}