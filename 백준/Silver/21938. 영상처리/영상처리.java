import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] matrix;
	static boolean[][] visited;
	static Deque<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		matrix = new int[N][M];
		visited = new boolean[N][M];
		queue = new ArrayDeque<>();
		int result = 0;
		
		for (int r = 0; r < N; r++) {
			String[] s = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				int avg = 0;
				for(int t = 3 * c; t < 3 * c + 3; t++ ) {
					avg += Integer.parseInt(s[t]);
				}
				matrix[r][c] = avg/3;
			}
		}

		int T = Integer.parseInt(br.readLine());

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {

				if (matrix[r][c] < T) {
					matrix[r][c] = 0;
				} else {
					matrix[r][c] = 255;
					queue.add(new int[] { r, c });
				}
			}
		}

		while(!queue.isEmpty()) {
			
			int [] curr = queue.poll();
			int startR = curr[0];
			int startC = curr[1];
			
			if(!visited[startR][startC]) {
				visited[startR][startC] = true;
				bfs(startR, startC);
				result++;
			}
			
		}

		sb.append(result);
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int cr, int cc) {

		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { cr, cc });

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			
			for(int i = 0; i < 4; i++) {
				
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && matrix[nr][nc] == 255) {
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
			}
			

		}

	}
}