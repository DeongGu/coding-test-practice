import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] matrix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		matrix = new int[N][M];

		int result = Integer.MAX_VALUE;

		for (int r = 0; r < N; r++) {

			String[] s = br.readLine().split("");

			for (int c = 0; c < M; c++) {
				matrix[r][c] = Integer.parseInt(s[c]);
			}

		}

		result = Math.min(result, bfs());

		if (result == Integer.MAX_VALUE) {
			sb.append(-1);
		} else {
			sb.append(result);
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs() {

		boolean[][][] visited = new boolean[N][M][2];

		Deque<int[]> queue = new ArrayDeque<>();

		queue.add(new int[] { 0, 0, 1, 0 });
		visited[0][0][0] = true;

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();

			int cr = curr[0];
			int cc = curr[1];
			int d = curr[2];
			int b = curr[3];

			if (cr == N - 1 && cc == M - 1) {
				return d;
			}

			for (int i = 0; i < 4; i++) {

				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {

					if (matrix[nr][nc] == 1) {

						if (b == 0 && !visited[nr][nc][1]) {
							visited[nr][nc][1] = true;
							queue.add(new int[] { nr, nc, d + 1, 1 });
						}

					} else {

						if (!visited[nr][nc][b]) {
							visited[nr][nc][b] = true;
							queue.add(new int[] { nr, nc, d + 1, b });
						}
					}

				}

			}

		}

		return Integer.MAX_VALUE;

	}

}