import java.io.*;
import java.util.*;

public class Main {

	static int M, N;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[][] matrix;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] MN = br.readLine().split(" ");
		M = Integer.parseInt(MN[0]);
		N = Integer.parseInt(MN[1]);
		matrix = new int[M][N];
		visited = new boolean[M][N];

		int result = 0;

		for (int r = 0; r < M; r++) {
			String[] s = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				matrix[r][c] = Integer.parseInt(s[c]);
				if (matrix[r][c] == 0)
					visited[r][c] = true;
			}
		}

		for (int r = 0; r < M; r++) {

			for (int c = 0; c < N; c++) {

				if (!visited[r][c]) {
					visited[r][c] = true;
					bfs(r, c);
					result++;
				}
			}
		}

		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();

	}

	static void bfs(int cr, int cc) {
		
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {cr, cc});
		
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			for(int i = 0; i < 8; i++) {
				
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				
				if(nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc] && matrix[nr][nc] == 1) {
					visited[nr][nc] = true;
					queue.add(new int[] {nr, nc});
				}
			}
			
		}
		
	}
}