import java.io.*;
import java.util.*;

public class Main {

	static int n, m, sr, sc;
	static int[][] matrix;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] nm = br.readLine().split(" ");

		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		visited = new boolean[n][m];
		matrix = new int[n][m];

		for (int r = 0; r < n; r++) {

			String[] s = br.readLine().split(" ");

			for (int c = 0; c < m; c++) {

				matrix[r][c] = Integer.parseInt(s[c]);

				if (matrix[r][c] == 2) {
					sr = r;
					sc = c;
				} else if (matrix[r][c] == 0) {
					visited[r][c] = true;
				}
			}

		}
		bfs(sr, sc, 0);

		matrix[sr][sc] = 0;
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				if(c == m-1) {
					
					if(visited[r][c]) {
						sb.append(matrix[r][c]);						
					}else {
						sb.append(-1);
					}
				}else{
					if(visited[r][c]) {
						sb.append(matrix[r][c]).append(" ");						
					}else {
						sb.append(-1).append(" ");
					}
				}
			}
			sb.append("\n");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int r, int c, int dep) {

		Deque<int[]> q = new ArrayDeque<>();

		visited[r][c] = true;

		q.add(new int[] { r, c, dep });

		while (!q.isEmpty()) {

			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			int d = curr[2];
			
			for (int i = 0; i < 4; i++) {

				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && matrix[nr][nc] == 1) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc, d + 1 });
					matrix[nr][nc] = d + 1;
				}
			}
			
		}
	}
}