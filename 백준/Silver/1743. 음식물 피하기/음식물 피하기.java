import java.io.*;
import java.util.*;

public class Main {

	static int N, M, K;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] matrix;
	static Deque<int[]> queue;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		K = Integer.parseInt(NM[2]);
		matrix = new int[N][M];
		visited = new boolean[N][M];
		queue = new ArrayDeque<>();

		int result = 0;
		
		for (int i = 0; i < K; i++) {
			String[] rc = br.readLine().split(" ");
			int r = Integer.parseInt(rc[0]) - 1;
			int c = Integer.parseInt(rc[1]) - 1;

			matrix[r][c] = 1;
			queue.add(new int[] { r, c });
		}
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int startR = curr[0];
			int startC = curr[1];
			
			result = Math.max(result, bfs(startR, startC));
		}
		
		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs(int cr, int cc) {

		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {cr, cc});
		visited[cr][cc] = true;
		int count = 1;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && matrix[nr][nc] == 1) {
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
					count++;
				}
			}
			
		}

		return count;
	}
}