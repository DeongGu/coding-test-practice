import java.io.*;
import java.util.*;

public class Main {

	static int N, r, c, R, C;
	static int[][] matrix;
	static int[] dr = { -2, -2, 0, 0, 2, 2 };
	static int[] dc = { -1, 1, -2, 2, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];

		String[] rcRC = br.readLine().split(" ");
		r = Integer.parseInt(rcRC[0]);
		c = Integer.parseInt(rcRC[1]);
		R = Integer.parseInt(rcRC[2]);
		C = Integer.parseInt(rcRC[3]);

		sb.append(bfs());

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs() {

		Deque<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		queue.add(new int[] { r, c ,0});
		visited[r][c] = true;

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();
			int cr = curr[0];
			int cc = curr[1];
			int count = curr[2];
			
			if(cr == R && cc == C) return count;

			for (int i = 0; i < 6; i++) {

				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && matrix[nr][nc] == 0) {
					visited[nr][nc] = true;
					matrix[nr][nc] = 1;
					queue.add(new int[] { nr, nc, count + 1 });
				}
			}

		}

		return -1;
	}

}