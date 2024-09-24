import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		int[][] matrix = new int[n][m];

		Stack<int[]> qStack = new Stack<>();
		Stack<int[]> kStack = new Stack<>();

		String[] q = br.readLine().split(" ");
		int qCount = Integer.parseInt(q[0]);

		for (int i = 0; i < qCount*2; i += 2) {
			int r = Integer.parseInt(q[i + 1]) - 1;
			int c = Integer.parseInt(q[i + 2]) - 1;

			matrix[r][c] = 10;
			qStack.push(new int[] { r, c });
		}

		String[] k = br.readLine().split(" ");
		int kCount = Integer.parseInt(k[0]);

		for (int i = 0; i < kCount*2; i += 2) {
			int r = Integer.parseInt(k[i + 1]) - 1;
			int c = Integer.parseInt(k[i + 2]) - 1;

			matrix[r][c] = 20;
			kStack.push(new int[] { r, c });
		}

		String[] p = br.readLine().split(" ");
		int pCount = Integer.parseInt(p[0]);

		for (int i = 0; i < pCount*2; i += 2) {
			int r = Integer.parseInt(p[i + 1]) - 1;
			int c = Integer.parseInt(p[i + 2]) - 1;

			matrix[r][c] = 30;
		}

		int[] kdr = { -1, -2, -2, -1, 1, 2, 2, 1 };
		int[] kdc = { -2, -1, 1, 2, 2, 1, -1, -2 };

		while (!kStack.isEmpty()) {

			int[] rc = kStack.pop();
			int r = rc[0];
			int c = rc[1];

			for (int i = 0; i < 8; i++) {

				int nr = r + kdr[i];
				int nc = c + kdc[i];

				if (nr >= 0 && nr < n && nc >= 0 && nc < m && matrix[nr][nc] == 0) {
					matrix[nr][nc] = 2;
				}
			}

		}

		int[] qdr = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] qdc = { 0, 1, 1, 1, 0, -1, -1, -1 };

		while (!qStack.isEmpty()) {

			int[] rc = qStack.pop();
			int r = rc[0];
			int c = rc[1];

			for (int j = 0; j < 8; j++) {
				for (int i = 0; i < Math.max(n, m); i++) {

					int nr = r + qdr[j] * (i + 1);
					int nc = c + qdc[j] * (i + 1);

					if (nr >= 0 && nr < n && nc >= 0 && nc < m) {

						if(matrix[nr][nc] == 10 || matrix[nr][nc] == 20 || matrix[nr][nc] == 30) {
							break;
						}else {							
							matrix[nr][nc] = 1;
						}

					}
				}
			}

		}

		int result = 0;

		for (int r = 0; r < n; r++) {

			for (int c = 0; c < m; c++) {

				if (matrix[r][c] == 0)
					result++;
			}
		}

		sb.append(result);


		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}