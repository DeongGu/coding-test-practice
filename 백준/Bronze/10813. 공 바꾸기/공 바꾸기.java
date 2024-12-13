import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		for (int s = 0; s < M; s++) {
			String[] ij = br.readLine().split(" ");
			int i = Integer.parseInt(ij[0]) - 1;
			int j = Integer.parseInt(ij[1]) - 1;

			int tmpI = arr[i];
			int tmpJ = arr[j];

			arr[i] = tmpJ;
			arr[j] = tmpI;

		}

		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append(" ");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}