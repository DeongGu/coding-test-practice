import java.io.*;
import java.util.*;

public class Main {

	static int N, result, num;
	static int[][] matrix;
	static boolean[][] visited;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		visited = new boolean[N][N];
		Deque<int[]> queue = new ArrayDeque<>();
		num = 1;
		result = Integer.MAX_VALUE;

		for (int r = 0; r < N; r++) {
			String[] s = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				matrix[r][c] = Integer.parseInt(s[c]);
				if (matrix[r][c] == 1) {
					queue.add(new int[] { r, c });
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			if (!visited[curr[0]][curr[1]]) {
				bfs(curr[0], curr[1]);
				num++;
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (matrix[r][c] > 0) {
					result = Math.min(result, getDistance(r, c));
				}
			}
		}

		sb.append(result);
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int r, int c) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { r, c });
		visited[r][c] = true;
		matrix[r][c] = num;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];

			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && matrix[nr][nc] == 1) {
					visited[nr][nc] = true;
					matrix[nr][nc] = num;
					q.add(new int[] { nr, nc });
				}
			}
		}
	}

	static int getDistance(int r, int c) {
		Deque<int[]> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][N];
		q.add(new int[] { r, c, 0 });
		visit[r][c] = true;
		int start = matrix[r][c];

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			int dist = curr[2];

			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc]) {
					visit[nr][nc] = true;

					if (matrix[nr][nc] == 0) {
						q.add(new int[] { nr, nc, dist + 1 });
					} else if (matrix[nr][nc] != start) {
						return dist;
					}
				}
			}
		}
		return Integer.MAX_VALUE;
	}
}