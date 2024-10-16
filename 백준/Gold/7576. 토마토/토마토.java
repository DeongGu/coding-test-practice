import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static Deque<int[]> q;
	static int result;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] MN = br.readLine().split(" ");
		M = Integer.parseInt(MN[0]);
		N = Integer.parseInt(MN[1]);
		q = new ArrayDeque<>();
		matrix = new int[N][M];
		visited = new boolean[N][M];
		result = 0;

		boolean check = false;

		for (int r = 0; r < N; r++) {

			String[] s = br.readLine().split(" ");

			for (int c = 0; c < M; c++) {

				if (Integer.parseInt(s[c]) == 0) {
					check = true;
				}

				if (Integer.parseInt(s[c]) == 1) {
					q.add(new int[] { r, c ,0});
				}

				if (Integer.parseInt(s[c]) == -1) {
					visited[r][c] = true;
				}

				matrix[r][c] = Integer.parseInt(s[c]);
			}
		}
		
		

		if (!check) {
			sb.append(0).append("\n");
		} else {

			bfs();

			boolean check2 = false;

			for (int r = 0; r < N; r++) {

				for (int c = 0; c < M; c++) {

					if (matrix[r][c] == 0) {
						sb.append(-1);
						check2 = true;
						break;
					}
				}

				if (check2)
					break;
			}

			if (!check2) {
				sb.append(result);
			}

		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs() {

		while (!q.isEmpty()) {

			int[] rc = q.pollFirst();
			
			visited[rc[0]][rc[1]] = true;

			for (int i = 0; i < 4; i++) {

				int nr = rc[0] + dr[i];
				int nc = rc[1] + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && matrix[nr][nc] == 0) {
					matrix[nr][nc] = 1;
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc, rc[2] + 1 });
				}

			}
			
			
			if(q.isEmpty()) result = rc[2];
		}
		
	}
}