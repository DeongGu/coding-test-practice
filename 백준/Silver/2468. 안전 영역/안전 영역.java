import java.io.*;
import java.util.*;

public class Main {

	static boolean[][] visited;
	static int[][] matrix;
	static int[][] area;
	static int N;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];

		int result = 1;

		for (int r = 0; r < N; r++) {

			String[] info = br.readLine().split(" ");

			for (int c = 0; c < N; c++) {
				matrix[r][c] = Integer.parseInt(info[c]);
			}
		}

		for (int h = 99; h > 0; h--) {

			visited = new boolean[N][N];
			area = new int[N][N];
			Deque<int[]> q = new ArrayDeque<>();
			int count = 0;

			for (int r = 0; r < N; r++) {

				for (int c = 0; c < N; c++) {

					if (matrix[r][c] > h) {
						area[r][c] = 1;
						q.add(new int[] { r, c });
					}

				}
			}

			while (!q.isEmpty()) {

				int[] rc = q.pollFirst();
				int r = rc[0];
				int c = rc[1];
				
				if(!visited[r][c]) {					
					bfs(r,c);
					count++;
				}

			}
			
			result = Math.max(result, count);

		}

		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	static void bfs(int row, int col) {
		
		Deque<int[]> q = new ArrayDeque<>();
		
		visited[row][col] = true;
		
		q.add(new int[] {row, col});
		
		while(!q.isEmpty()) {
			
			int[] rc = q.pollFirst();
			
			int r = rc[0];
			int c = rc[1];
			

			for(int i = 0; i < 4; i++) {
				
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && area[nr][nc] == 1) {
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
				
			}
		}
		
	}

}