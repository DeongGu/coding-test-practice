import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int count = Integer.parseInt(br.readLine());

		String[] state = br.readLine().split(" ");

		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {
			String[] info = br.readLine().split(" ");
			
			int gender = Integer.parseInt(info[0]);
			int switchNum = Integer.parseInt(info[1]);
			
			if (gender == 1) {
				for (int j =  switchNum-1; j < count; j += switchNum) {
					if (state[j].equals("0")) {
						state[j] = "1";
					} else {
						state[j] = "0";
					}
				}
			} else {
				
				int first = switchNum - 1;
				int end = switchNum - 1;

				while(first - 1 >= 0 && end + 1 < count && state[first-1].equals(state[end+1])) {
					first--;
					end++;
				}
				
				for (int j = first; j <= end; j++) {

					if (state[j].equals("0")) {
						state[j] = "1";
					} else {
						state[j] = "0";
					}
				}
				
			}
		}

		
		for (int i = 0; i < count; i++) {
			sb.append(state[i]).append(" ");
			if ((i + 1) % 20 == 0) {
				sb.append("\n");
			}
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}

}