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

		for (int r = 0; r < N; r++) {
			String[] s = br.readLine().split("");
			for (int c = 0; c < M; c++) {
				if (s[c].equals("W")) {
					matrix[r][c] = 1;
				}
			}
		}

		int result = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (matrix[r][c] == 0) {
					result = Math.max(bfs(r, c), result);
				}
			}
		}

		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs(int sr, int sc) {
		boolean[][] visited = new boolean[N][M];
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { sr, sc });
		visited[sr][sc] = true;
		int distance = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] curr = q.poll();
				int r = curr[0];
				int c = curr[1];

				for (int dir = 0; dir < 4; dir++) {
					int nr = r + dr[dir];
					int nc = c + dc[dir];

					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && matrix[nr][nc] == 0) {
						visited[nr][nc] = true;
						q.add(new int[] { nr, nc });
					}
				}
			}
			distance++;
		}

		return distance - 1;
	}
}