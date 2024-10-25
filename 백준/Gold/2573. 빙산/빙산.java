import java.io.*;
import java.util.*;

public class Main {

	static int N, M, result;
	static boolean[][] visited;
	static Deque<int[]> q;
	static int[][] matrix;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");

		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		result = 0;
		matrix = new int[N][M];
		visited = new boolean[N][M];
		q = new ArrayDeque<>();

		for (int r = 0; r < N; r++) {

			String[] s = br.readLine().split(" ");

			for (int c = 0; c < M; c++) {

				if (Integer.parseInt(s[c]) != 0) {
					matrix[r][c] = Integer.parseInt(s[c]);
					q.add(new int[] { r, c });
				} else {
					visited[r][c] = true;
				}

			}
		}

		while (true) {

			visited = new boolean[N][M];
			int count = 0;

			for (int r = 0; r < N; r++) {

				for (int c = 0; c < M; c++) {

					if (matrix[r][c] > 0 && !visited[r][c]) {
						bfs(r, c);
						count++;
					}
				}
			}

			if (count > 1) {
				sb.append(result).append(" ");
				break;
			}

			if (q.isEmpty()) {
				sb.append(0);
				break;
			}

			repeat();
			result++;

		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void repeat() {

		int[][] tmp = new int[N][M];
		Deque<int[]> nq = new ArrayDeque<>();

		while (!q.isEmpty()) {

			int[] rc = q.pollFirst();
			
			int r = rc[0];
			int c = rc[1];

			int d = 0;

			for (int i = 0; i < 4; i++) {

				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && matrix[nr][nc] == 0) {
					d++;
				}

			}

			tmp[r][c] = Math.max(0, matrix[r][c] - d);

			if (tmp[r][c] > 0)
				nq.add(new int[] { r, c });

		}

		matrix = tmp;
		q = nq;
	}

	static void bfs(int row, int col) {

		Deque<int[]> nq = new ArrayDeque<>();
		nq.add(new int[] { row, col });
		visited[row][col] = true;

		while (!nq.isEmpty()) {

			int[] crcc = nq.pollFirst();
			int cr = crcc[0];
			int cc = crcc[1];

			for (int i = 0; i < 4; i++) {

				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && matrix[nr][nc] > 0) {
					visited[nr][nc] = true;
					nq.add(new int[] { nr, nc });
				}

			}

		}

	}

}