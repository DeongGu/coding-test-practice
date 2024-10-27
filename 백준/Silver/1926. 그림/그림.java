import java.io.*;
import java.util.*;

public class Main {

	static int n, m, count, result;
	static int[][] matrix;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		matrix = new int[n][m];
		visited = new boolean[n][m];

		Deque<int[]> q = new ArrayDeque<>();

		for (int r = 0; r < n; r++) {

			String[] s = br.readLine().split(" ");

			for (int c = 0; c < m; c++) {

				matrix[r][c] = Integer.parseInt(s[c]);

				if (matrix[r][c] == 1)
					q.add(new int[] { r, c });
			}
		}

		while (!q.isEmpty()) {

			int[] curr = q.poll();

			if (!visited[curr[0]][curr[1]]) {
				bfs(curr[0], curr[1]);
				count++;
			}

		}

		sb.append(count).append("\n").append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int row, int col) {

		visited[row][col] = true;

		Deque<int[]> que = new ArrayDeque<>();

		que.add(new int[] { row, col });
		
		int extent = 0;
		
		while (!que.isEmpty()) {

			int[] curr = que.poll();

			int cr = curr[0];
			int cc = curr[1];

			for (int i = 0; i < 4; i++) {

				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && matrix[nr][nc] == 1) {
					visited[nr][nc] = true;
					que.add(new int[] { nr, nc});
					extent++;
				}
			}

			
			if(que.isEmpty()) {
				result = Math.max(result, extent+1);
			}
		}
	}
}