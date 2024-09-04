import java.io.*;
import java.util.*;

public class Solution {

	static int N, M;
	static String[][] map;
	static int[][] sum;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			String[] NM = br.readLine().split(" ");

			N = Integer.parseInt(NM[0]);
			M = Integer.parseInt(NM[1]);

			map = new String[N][M];
			sum = new int[N][M];

			for (int i = 0; i < N; i++) {

				String[] s = br.readLine().split("");

				for (int j = 0; j < M; j++) {
					map[i][j] = s[j];
					if (map[i][j].equals("W")) {
						que.add(new int[] { i, j });
						sum[i][j] = 0;
					} else {
						sum[i][j] = Integer.MAX_VALUE;
					}
				}
			}

			bfs();

			int result = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (!map[r][c].equals("W")) {
						result += sum[r][c];
					}
				}
			}

			sb.append("#").append(tc + 1).append(" ").append(result).append("\n");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}

	static Queue<int[]> que = new LinkedList<int[]>();

	static void bfs() {

		while (!que.isEmpty()) {

			int[] current = que.poll();

			int cr = current[0];
			int cc = current[1];

			for (int i = 0; i < 4; i++) {

				int newCr = cr + dr[i];
				int newCc = cc + dc[i];

				if (newCr >= 0 && newCr < N && newCc >= 0 && newCc < M) {

					if (sum[newCr][newCc] > sum[cr][cc] + 1) {
						sum[newCr][newCc] = sum[cr][cc] + 1;
						que.add(new int[] { newCr, newCc });
					}

				}
			}

		}

	}

}