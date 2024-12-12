import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		String[] A = br.readLine().split(" ");

		String[] BC = br.readLine().split(" ");

		int B = Integer.parseInt(BC[0]);
		int C = Integer.parseInt(BC[1]);

		long result = N;

		for (int i = 0; i < N; i++) {

			int n = Integer.parseInt(A[i]);

			if (n > B) {
				result += (n - B) / C;
				if ((n - B) % C != 0) {
					result += 1;
				}
			}
		}

		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}