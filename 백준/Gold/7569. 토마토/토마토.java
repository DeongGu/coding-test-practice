import java.io.*;
import java.util.*;

public class Main {

	static int M, N, H, result;
	static int[][][] matrix;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] dh = { 1, -1 };

	static Deque<int[]> q;

	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] MNH = br.readLine().split(" ");
		M = Integer.parseInt(MNH[0]);
		N = Integer.parseInt(MNH[1]);
		H = Integer.parseInt(MNH[2]);
		visited = new boolean[H][N][M];
		matrix = new int[H][N][M];

		result = 0;

		boolean check = false;

		q = new ArrayDeque<>();

		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				String[] s = br.readLine().split(" ");
				for (int c = 0; c < M; c++) {
					matrix[h][r][c] = Integer.parseInt(s[c]);

					if (Integer.parseInt(s[c]) == 0)
						check = true;

					if (Integer.parseInt(s[c]) == 1) {
						visited[h][r][c] = true;
						q.add(new int[] { h, r, c, 0 });
					}

					if (Integer.parseInt(s[c]) == -1)
						visited[h][r][c] = true;
				}
			}
		}

		if (!check) {
			sb.append(0);
		} else {

			bfs();

			boolean check2 = true;

			for (int h = 0; h < H; h++) {
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {

						if (matrix[h][r][c] == 0) {
							check2 = false;
						}

					}

				}
			}

			sb.append(check2 ? result : -1);
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs() {
		
		while (!q.isEmpty()) {

			int[] hrc = q.pollFirst();

			for (int i = 0; i < 4; i++) {
				int nr = hrc[1] + dr[i];
				int nc = hrc[2] + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[hrc[0]][nr][nc] && matrix[hrc[0]][nr][nc] == 0) {
					visited[hrc[0]][nr][nc] = true;
					q.add(new int[] { hrc[0], nr, nc, hrc[3] + 1 });
					matrix[hrc[0]][nr][nc] = 1;
				}
			}

			for (int i = 0; i < 2; i++) {

				int nh = hrc[0] + dh[i];

				if (nh >= 0 && nh < H && !visited[nh][hrc[1]][hrc[2]] && matrix[nh][hrc[1]][hrc[2]] == 0) {
					visited[nh][hrc[1]][hrc[2]] = true;
					q.add(new int[] { nh, hrc[1], hrc[2], hrc[3] + 1 });
					matrix[nh][hrc[1]][hrc[2]] = 1;
				}

			}

			
			if(q.isEmpty()) result = hrc[3];
		}

	}
}