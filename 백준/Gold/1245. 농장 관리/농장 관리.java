import java.io.*;
import java.util.*;

public class Main {

	static int N, M, result;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		matrix = new int[N][M];
		visited = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			String[] s = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				matrix[r][c] = Integer.parseInt(s[c]);
			}
		}

		result = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (!visited[r][c] && matrix[r][c] > 0) {
					if (isPeak(r, c)) {
						result++;
					}
				}
			}
		}

		System.out.println(result);
	}

	static boolean isPeak(int sr, int sc) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { sr, sc });
		visited[sr][sc] = true;

		boolean isPeak = true;
		int height = matrix[sr][sc];

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			for (int i = 0; i < 8; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (matrix[nr][nc] > height) {
						isPeak = false;
					}

					if (!visited[nr][nc] && matrix[nr][nc] == height) {
						visited[nr][nc] = true;
						queue.add(new int[] { nr, nc });
					}
				}
			}
		}

		return isPeak;
	}
}