import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] matrix;
	static int[] dr = { 1, 0 };
	static int[] dc = { 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];

		for (int r = 0; r < N; r++) {
			String[] s = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				matrix[r][c] = Integer.parseInt(s[c]);
			}
		}

		sb.append(bfs());

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();

	}

	static String bfs() {

		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { 0, 0 });
		boolean[][] visited = new boolean[N][N];
		visited[0][0] = true;

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];

			if (r == N - 1 && c == N - 1 && matrix[r][c] == -1) {
				return "HaruHaru";
			}

			for (int i = 0; i < 2; i++) {
				int nr = r + dr[i] * matrix[r][c];
				int nc = c + dc[i] * matrix[r][c];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc <N && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.add(new int[] {nr, nc});
				}
			}

		}

		return "Hing";
	}
}