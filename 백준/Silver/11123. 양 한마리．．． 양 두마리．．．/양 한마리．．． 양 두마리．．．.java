import java.io.*;
import java.util.*;

public class Main {

	static int H, W, result;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] matrix;
	static boolean[][] visited;
	static Deque<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			String[] HW = br.readLine().split(" ");
			queue = new ArrayDeque<>();
			H = Integer.parseInt(HW[0]);
			W = Integer.parseInt(HW[1]);
			matrix = new int[H][W];
			visited = new boolean[H][W];
			result = 0;
			for (int r = 0; r < H; r++) {
				String[] s = br.readLine().split("");

				for (int c = 0; c < W; c++) {

					if (s[c].equals(".")) {
						matrix[r][c] = 1;
					} else {
						queue.add(new int[] { r, c });
					}
				}
			}
			
			while(!queue.isEmpty()) {
				int[] curr = queue.poll();
				int r = curr[0];
				int c = curr[1];
				
				if(!visited[r][c]) {					
					bfs(r,c);
					result++;
				}
			}

			sb.append(result).append("\n");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int cr, int cc) {

		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {cr, cc});
		visited[cr][cc] = true;
		
		while (!q.isEmpty()) {

			int[] curr = q.poll();
		
			int r = curr[0];
			int c = curr[1];

			for (int i = 0; i < 4; i++) {

				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < H && nc >= 0 && nc < W && !visited[nr][nc] && matrix[nr][nc] == 0) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}
			}

		}

	}

}