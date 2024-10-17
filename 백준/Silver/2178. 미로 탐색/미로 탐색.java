
import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] maze;
	static StringBuilder sb;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder(100);

		String[] NM = br.readLine().split(" ");

		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		maze = new int[N + 1][M + 1];

		for (int r = 1; r <= N; r++) {
			String[] s = br.readLine().split("");
			for (int c = 1; c <= M; c++) {
				maze[r][c] = Integer.parseInt(s[c - 1]);
			}
		}

		bfs();

		sb.append(maze[N][M]);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

	static Queue<int[]> que = new LinkedList<int[]>();

	static void bfs() {
		int[] start = { 1, 1 };
		que.offer(start);

		while (!que.isEmpty()) {

			int[] current = que.poll();

			int cr = current[0];
			int cc = current[1];

			for (int i = 0; i < 4; i++) {

				int newCr = cr + dr[i];
				int newCc = cc + dc[i];

				if (newCr >= 1 && newCr <= N && newCc >= 1 && newCc <= M) {

					if (maze[newCr][newCc] == 1) {
						int[] newStart = { newCr, newCc };
						maze[newCr][newCc] += maze[cr][cc];
						que.offer(newStart);
					}

				}

			}

		}

	}

}