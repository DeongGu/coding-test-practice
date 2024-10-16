import java.io.*;
import java.util.*;

public class Main {

	static Deque<int[]> q;
	static int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static boolean[][] visited;
	static int[][] map;
	static int l, endR, endC, result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			l = Integer.parseInt(br.readLine());

			String[] start = br.readLine().split(" ");

			int cr = Integer.parseInt(start[0]);
			int cc = Integer.parseInt(start[1]);

			String[] end = br.readLine().split(" ");
			
			endR = Integer.parseInt(end[0]);
			endC = Integer.parseInt(end[1]);
			
			visited = new boolean[l][l];

			result = Integer.MAX_VALUE;
			
			bfs(cr, cc, 0);
			
			sb.append(result).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int row, int col, int dep) {

		visited[row][col] = true;

		Deque<int[]> qu = new ArrayDeque<>();

		qu.add(new int[] { row, col, dep });
		
		while (!qu.isEmpty()) {

			int[] rc = qu.pollFirst();
			
			for (int i = 0; i < 8; i++) {

				int nr = rc[0] + dr[i];
				int nc = rc[1] + dc[i];

				if (nr >= 0 && nr < l && nc >= 0 && nc < l && !visited[nr][nc]) {
					visited[nr][nc] = true;
					qu.add(new int[] { nr, nc , rc[2]+1});
					if(nr == endR && nc == endC) {
						result = rc[2]+1;
						return;
					}
					
					result = 0;
				}
			}
		}

	}

}