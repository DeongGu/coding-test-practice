import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = { 0, 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 0, 1, 0, -1 };
	static int[] dl = { 1, -1, 0, 0, 0, 0 };
	static int L, R, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while (true) {

			String[] LRC = br.readLine().split(" ");
			L = Integer.parseInt(LRC[0]);
			R = Integer.parseInt(LRC[1]);
			C = Integer.parseInt(LRC[2]);

			if (L == 0 && R == 0 && C == 0)
				break;

			int startR = 0;
			int startC = 0;
			int startL = 0;

			int endR = 0;
			int endC = 0;
			int endL = 0;

			int[][][] building = new int[R][C][L];
			boolean[][][] visited = new boolean[R][C][L];

			for (int l = 0; l < L; l++) {

				for (int r = 0; r < R; r++) {
					String[] s = br.readLine().split("");

					for (int c = 0; c < C; c++) {

						if (s[c].equals("S")) {
							startR = r;
							startC = c;
							startL = l;
						} else if (s[c].equals("E")) {
							endR = r;
							endC = c;
							endL = l;
						} else if (s[c].equals("#")) {
							building[r][c][l] = 1;
						}

					}
				}

				br.readLine();
			}

			sb.append(bfs(startR, startC, startL, endR, endC, endL, visited, building)).append("\n");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();

	}

	static String bfs(int sr, int sc, int sl, int er, int ec, int el, boolean[][][] visited, int[][][] building) {

		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { sr, sc, sl, 0 });

		visited[sr][sc][sl] = true;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];
			int l = curr[2];
			int count = curr[3];

			if (r == er && c == ec && l == el) {
				return "Escaped in " + Integer.toString(count) +" minute(s).";
			}

			for (int i = 0; i < 6; i++) {

				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				int nl = curr[2] + dl[i];

				if (nr >= 0 && nr < R && nc >= 0 && nc < C && nl >= 0 && nl < L && !visited[nr][nc][nl]
						&& building[nr][nc][nl] == 0) {
					visited[nr][nc][nl] = true;
					queue.add(new int[] { nr, nc, nl, count + 1 });
				}

			}

		}

		return "Trapped!";
	}
}