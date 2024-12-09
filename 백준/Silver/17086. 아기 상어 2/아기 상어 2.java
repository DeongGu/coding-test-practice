import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] matrix;
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		matrix = new int[N][M];
		Queue<int[]> queue = new ArrayDeque<>();

		for (int r = 0; r < N; r++) {
			String[] s = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				matrix[r][c] = Integer.parseInt(s[c]);
				if (matrix[r][c] == 1) {
					queue.add(new int[] { r, c });
				}
			}
		}

		int result = bfs(queue);
		System.out.println(result);
	}

	static int bfs(Queue<int[]> queue) {
		int[][] distance = new int[N][M];
		int maxDistance = 0;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			for (int i = 0; i < 8; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && distance[nr][nc] == 0 && matrix[nr][nc] == 0) {
					distance[nr][nc] = distance[curr[0]][curr[1]] + 1;
					maxDistance = Math.max(maxDistance, distance[nr][nc]);
					queue.add(new int[] { nr, nc });
				}
			}
		}

		return maxDistance;
	}
}
