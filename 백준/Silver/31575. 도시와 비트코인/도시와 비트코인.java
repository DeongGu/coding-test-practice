import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] dr = { 0, 1 };
	static int[] dc = { 1, 0 };
	static int[][] matrix;
	static boolean[][] visited; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		matrix = new int[M][N];
		visited = new boolean[M][N];

		for (int r = 0; r < M; r++) {

			String[] s = br.readLine().split(" ");

			for (int c = 0; c < N; c++) {
				matrix[r][c] = Integer.parseInt(s[c]);
				if(matrix[r][c] == 0) visited[r][c] = true;
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
		queue.add(new int[] {0,0});
		
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			int cr = curr[0];
			int cc = curr[1];
			
			if(cr == M - 1 && cc == N - 1) return "Yes";
			
			for(int i = 0; i < 2; i++) {
				
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if(nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc] && matrix[nr][nc] == 1) {
					visited[nr][nc] = true;
					queue.add(new int[] {nr, nc});
				}
			}		
		}
		return "No";
	}
}
