import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);

		int[][] matrix = new int[N][N];

		List<int[]> list = new ArrayList<>();

		for (int r = 0; r < N; r++) {
			String[] s = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				matrix[r][c] = Integer.parseInt(s[c]);
				if (matrix[r][c] > 0) {
					list.add(new int[] { r, c, matrix[r][c]});
				}
			}
		}
		
		Collections.sort(list, Comparator.comparingInt(a -> a[2]));
		
		Deque<int[]> queue = new ArrayDeque<>();
		
		for(int[] w : list) {
			queue.add(new int[] {w[0], w[1], w[2], 0});
		}

		String[] SXY = br.readLine().split(" ");
		int S = Integer.parseInt(SXY[0]);
		int X = Integer.parseInt(SXY[1]) - 1;
		int Y = Integer.parseInt(SXY[2]) - 1;

		bfs(N, S, matrix, queue);

		sb.append(matrix[X][Y]);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int n, int s, int[][] matrix, Deque<int[]> queue) {

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();

			int r = curr[0];
			int c = curr[1];
			int v = curr[2];
			int time = curr[3];

			if (time == s)
				return;

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < n && nc >= 0 && nc < n && matrix[nr][nc] == 0) {
					matrix[nr][nc] = v;
					queue.add(new int[] { nr, nc, v, time + 1 });
				}
			}
		}

	}
}