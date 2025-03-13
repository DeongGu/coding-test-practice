import java.io.*;
import java.util.*;

public class Main {

	static int r, c;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] matrix;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		matrix = new int[5][5];
		visited = new boolean[5][5];

		for (int R = 0; R < 5; R++) {
			String[] s = br.readLine().split(" ");
			for (int C = 0; C < 5; C++) {
				matrix[R][C] = Integer.parseInt(s[C]);
				if (matrix[R][C] == -1) {
					visited[R][C] = true;
				}
			}
		}

		String[] rc = br.readLine().split(" ");
		r = Integer.parseInt(rc[0]);
		c = Integer.parseInt(rc[1]);

		sb.append(bfs(r, c));

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs(int sr, int sc) {

		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { sr, sc, 0 });

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			int move = curr[2];
			
			if(matrix[cr][cc] == 1) return move;
			
			for(int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if(nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc, move + 1});
				}
			}
			
			
		}
		
		return -1;
	}
}