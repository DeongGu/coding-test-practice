import java.io.*;
import java.util.*;

public class Main {

	static int N, M, result;
	static int[][] matrix;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] NM = br.readLine().split(" ");
		
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		matrix = new int[N][M];
		
		int sr = 0, sc = 0;
		
		for(int r = 0; r < N; r++) {
			
			String[] s = br.readLine().split("");
			
			for(int c = 0; c < M; c++) {
				
				if(s[c].equals("X")) {					
					matrix[r][c] = 1;
				}else if(s[c].equals("P")) {
					matrix[r][c] = 2;
				}else if(s[c].equals("I")) {
					sr = r;
					sc = c;
				}
			}
		}
		
		bfs(sr, sc);
		
		if(result == 0) {
			sb.append("TT");
		}else {			
			sb.append(result);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs(int startR, int startC) {
		
		Deque<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		
		queue.add(new int[] {startR, startC});
		
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for(int i = 0; i < 4; i++) {
				
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && (matrix[nr][nc] == 0 || matrix[nr][nc] == 2 )) {
					visited[nr][nc] = true;
					queue.add(new int[] {nr, nc});
					if(matrix[nr][nc] == 2) result++;
				}
			}
			
		}
		
	}

}
