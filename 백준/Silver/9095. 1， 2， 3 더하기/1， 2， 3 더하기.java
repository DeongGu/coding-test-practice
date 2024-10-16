import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];

			arr[0] = 1;

			if(n > 1) arr[1] = 2;
			if(n > 2) arr[2] = 4;
			
			if(n > 3) {				
				for (int i = 3; i < n; i++) {
					arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
				}
			}

			sb.append(arr[n - 1]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}