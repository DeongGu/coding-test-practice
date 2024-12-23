import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int[] revenue = new int[N];
		int[] result = new int[N + 1];

		for (int i = 0; i < N; i++) {
			String[] TP = br.readLine().split(" ");
			arr[i] = Integer.parseInt(TP[0]);
			revenue[i] = Integer.parseInt(TP[1]);
		}

		for (int i = 0; i < N; i++) {

			result[i + 1] = Math.max(result[i + 1], result[i]);

			if (i + arr[i] <= N) {
				result[i + arr[i]] = Math.max(result[i + arr[i]], result[i] + revenue[i]);
			}
		}

		sb.append(result[N]);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}