import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] matrix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		matrix = new int[N][N];
		boolean[][] visited1 = new boolean[N][N];
		boolean[][] visited2 = new boolean[N][N];

		Deque<int[]> Rq = new ArrayDeque<>();
		Deque<int[]> Bq = new ArrayDeque<>();
		Deque<int[]> Gq = new ArrayDeque<>();
		Deque<int[]> Mq = new ArrayDeque<>();

		int R = 0;
		int B = 0;
		int G = 0;
		int M = 0;

		for (int r = 0; r < N; r++) {

			String[] s = br.readLine().split("");

			for (int c = 0; c < N; c++) {

				if (s[c].equals("G")) {
					matrix[r][c] = 1;
					Gq.add(new int[] { r, c });
					Mq.add(new int[] { r, c });
				} else if (s[c].equals("B")) {
					matrix[r][c] = 2;
					Bq.add(new int[] { r, c });
				} else {
					Rq.add(new int[] { r, c });
					Mq.add(new int[] { r, c });
				}
			}
		}

		while (!Rq.isEmpty()) {
			int[] curr = Rq.poll();
			int r = curr[0];
			int c = curr[1];

			if (!visited1[r][c]) {
				bfs(r, c, visited1, 0, 0);
				R++;
			}
		}

		while (!Gq.isEmpty()) {
			int[] curr = Gq.poll();
			int r = curr[0];
			int c = curr[1];

			if (!visited1[r][c]) {
				bfs(r, c, visited1, 1, 1);
				G++;
			}
		}

		while (!Bq.isEmpty()) {
			int[] curr = Bq.poll();
			int r = curr[0];
			int c = curr[1];

			if (!visited1[r][c]) {
				bfs(r, c, visited1, 2, 2);
				B++;
			}
		}

		while (!Mq.isEmpty()) {
			int[] curr = Mq.poll();
			int r = curr[0];
			int c = curr[1];

			if (!visited2[r][c]) {
				bfs(r, c, visited2, 0, 1);
				M++;
			}
		}

		sb.append(R + G + B).append(" ").append(M + B);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int sr, int sc, boolean[][] visited, int color1, int color2) {

		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { sr, sc });

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];

			for (int i = 0; i < 4; i++) {

				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]
						&& (matrix[nr][nc] == color1 || matrix[nr][nc] == color2)) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}
			}

		}

	}
}
