import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	static int N, M, K, result;
	static boolean[][] visited;
	static int[][] matrix;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Deque<int[]> q = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			String[] MNK = br.readLine().split(" ");

			N = Integer.parseInt(MNK[1]);
			M = Integer.parseInt(MNK[0]);
			K = Integer.parseInt(MNK[2]);

			matrix = new int[N][M];
			visited = new boolean[N][M];

			result = 0;

			for (int i = 0; i < K; i++) {
				String[] rc = br.readLine().split(" ");
				int r = Integer.parseInt(rc[1]);
				int c = Integer.parseInt(rc[0]);

				q.add(new int[] { r, c });
				matrix[r][c] = 1;
			}

			while (!q.isEmpty()) {

				int[] crcc = q.pollFirst();

				if (!visited[crcc[0]][crcc[1]]) {
					visited[crcc[0]][crcc[1]] = true;

					for (int i = 0; i < 4; i++) {

						int nr = crcc[0] + dr[i];
						int nc = crcc[1] + dc[i];

						if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && matrix[nr][nc] == 1) {
							visited[nr][nc] = true;
							dfs(nr, nc);
						}

					}

					result++;

				}

			}

			sb.append(result).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int r, int c) {

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && matrix[nr][nc] == 1) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}

		}

	}

}