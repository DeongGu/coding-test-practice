import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			String[] s = br.readLine().split("");
			int count = 0;

			for (int i = 0; i < s.length; i++) {

				if (s[i].equals("(")) {
					count++;
				} else {
					count--;
				}
							
				if(count < 0) {
					sb.append("NO").append("\n");
					break;
				}

			}
			
			if(count > 0) {
				sb.append("NO").append("\n");
			}else if(count == 0) {
				sb.append("YES").append("\n");
			}

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}