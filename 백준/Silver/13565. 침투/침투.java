import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] matrix;
	static boolean[][] visited;
	static Deque<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		visited = new boolean[N][M];
		queue = new ArrayDeque<>();

		matrix = new int[N][M];

		for (int r = 0; r < N; r++) {

			String[] s = br.readLine().split("");

			for (int c = 0; c < M; c++) {

				if (r == 0) {
					if (Integer.parseInt(s[c]) == 0) {
						queue.add(new int[] { r, c });
					}
				}

				matrix[r][c] = Integer.parseInt(s[c]);

				if (matrix[r][c] == 1) {
					visited[r][c] = true;
				}
			}
		}

		bfs();

		boolean check = false;

		for (int i = 0; i < M; i++) {
			if (matrix[N - 1][i] == 2) {
				check = true;
			}
		}

		if (check) {
			sb.append("YES");
		} else {
			sb.append("NO");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs() {

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];

			for (int i = 0; i < 4; i++) {

				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && matrix[nr][nc] == 0) {
					visited[nr][nc] = true;
					matrix[nr][nc] = 2;
					queue.add(new int[] { nr, nc });
				}
			}

		}

	}

}