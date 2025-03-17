import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] matrix;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Deque<int[]> Bq, Wq;
	static boolean[][] Bvisited;
	static boolean[][] Wvisited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		matrix = new int[M][N];
		Bq = new ArrayDeque<>();
		Wq = new ArrayDeque<>();

		Bvisited = new boolean[M][N];
		Wvisited = new boolean[M][N];
		
		int Wresult = 0;
		int Bresult = 0;
			
		for (int r = 0; r < M; r++) {

			String[] s = br.readLine().split("");

			for (int c = 0; c < N; c++) {

				if (s[c].equals("B")) {
					matrix[r][c] = 1;
					Bq.add(new int[] { r, c });
					Wvisited[r][c] = true;
				} else {
					Wq.add(new int[] { r, c });
					Bvisited[r][c] = true;
				}

			}
		}

		while (!Wq.isEmpty()) {
			int[] curr = Wq.poll();
			int startR = curr[0];
			int startC = curr[1];
			
			if(!Wvisited[startR][startC]) {
				Wvisited[startR][startC] = true;
				Wresult += bfs(startR, startC, Wvisited);
			}
		}

		while (!Bq.isEmpty()) {
			int[] curr = Bq.poll();
			int startR = curr[0];
			int startC = curr[1];
			
			if(!Bvisited[startR][startC]) {
				Bvisited[startR][startC] = true;
				Bresult += bfs(startR, startC, Bvisited);
			}
		}

		sb.append(Wresult).append(" ").append(Bresult);
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs(int r, int c, boolean[][] visited) {

		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { r, c });
		int count = 1;

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();
			int cr = curr[0];
			int cc = curr[1];

			for (int i = 0; i < 4; i++) {

				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.add(new int[] { nr, nc });
					count++;
				}
			}

		}

		return count*count;
	}

}