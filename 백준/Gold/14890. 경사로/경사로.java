import java.io.*;

public class Main {

	static int N, L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NL = br.readLine().split(" ");
		N = Integer.parseInt(NL[0]);
		L = Integer.parseInt(NL[1]);

		int[][] map = new int[N][N];
		for (int r = 0; r < N; r++) {
			String[] s = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(s[c]);
			}
		}

		int result = 0;

		for (int i = 0; i < N; i++) {
			if (passCheck(map[i])) {
				result++;
			}
		}

		for (int c = 0; c < N; c++) {

			int[] temp = new int[N];

			for (int r = 0; r < N; r++) {
				temp[r] = map[r][c];
			}

			if (passCheck(temp)) {
				result++;
			}
		}

		sb.append(result);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static boolean passCheck(int[] arr) {

		boolean[] used = new boolean[N];

		for (int i = 1; i < N; i++) {

			if (arr[i - 1] == arr[i]) {
				continue;
			}

			if (Math.abs(arr[i - 1] - arr[i]) > 1) {
				return false;
			}

			if (arr[i - 1] > arr[i]) {

				if (i + L > N)
					return false;

				for (int j = i; j < i + L; j++) {
					if (arr[j] != arr[i] || used[j]) {
						return false;
					}
				}

				for (int j = i; j < i + L; j++) {
					used[j] = true;
				}

			}else if (arr[i - 1] < arr[i]) {

				if (i - L < 0)
					return false;

				for (int j = i - L; j < i; j++) {

					if (arr[i - 1] != arr[j] || used[j]) {
						return false;
					}
				}

				for (int j = i - L; j < i; j++) {
					used[j] = true;
				}

			}

		}

		return true;
	}

}