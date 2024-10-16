import java.io.*;
import java.util.*;

public class Main {

	static Deque<int[]> q;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static boolean[][] visited;
	static int[][] map;
	static int w, h;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while (true) {

			int result = 0;

			String[] wh = br.readLine().split(" ");
			w = Integer.parseInt(wh[0]);
			h = Integer.parseInt(wh[1]);

			map = new int[h][w];
			visited = new boolean[h][w];

			q = new ArrayDeque<>();

			if (w == 0 && h == 0)
				break;

			for (int r = 0; r < h; r++) {

				String[] s = br.readLine().split(" ");

				for (int c = 0; c < w; c++) {
					map[r][c] = Integer.parseInt(s[c]);

					if (Integer.parseInt(s[c]) == 1)
						q.add(new int[] { r, c });
				}
			}

			while (!q.isEmpty()) {

				int[] crcc = q.pollFirst();

				if (!visited[crcc[0]][crcc[1]]) {
					bfs(crcc[0], crcc[1]);
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

	static void bfs(int row, int col) {

		visited[row][col] = true;

		Deque<int[]> qu = new ArrayDeque<>();

		qu.add(new int[] { row, col });

		while (!qu.isEmpty()) {

			int[] rc = qu.pollFirst();

			for (int i = 0; i < 8; i++) {

				int nr = rc[0] + dr[i];
				int nc = rc[1] + dc[i];

				if (nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc] && map[nr][nc] == 1) {

					visited[nr][nc] = true;
					qu.add(new int[] { nr, nc });
				}
			}
		}

	}

}