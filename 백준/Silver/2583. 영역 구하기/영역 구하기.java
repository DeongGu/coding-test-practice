import java.io.*;
import java.util.*;

public class Main {

	static int M, N, K;
	static List<Integer> list;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] MNK = br.readLine().split(" ");

		M = Integer.parseInt(MNK[0]);
		N = Integer.parseInt(MNK[1]);
		K = Integer.parseInt(MNK[2]);

		matrix = new int[M][N];
		visited = new boolean[M][N];
		list = new ArrayList<>();

		for (int i = 0; i < K; i++) {

			String[] xy = br.readLine().split(" ");
			int x1 = Integer.parseInt(xy[0]);
			int y1 = Integer.parseInt(xy[1]);
			int x2 = Integer.parseInt(xy[2]);
			int y2 = Integer.parseInt(xy[3]);

			for (int r = M - y2; r < M - y1; r++) {
				for (int c = x1; c < x2; c++) {
					matrix[r][c] = 1;
					visited[r][c] = true;
				}
			}
		}

		Deque<int[]> q = new ArrayDeque<>();

		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if (matrix[r][c] == 0)
					q.add(new int[] { r, c });
			}
		}

		while (!q.isEmpty()) {

			int[] rc = q.pollFirst();
			if(!visited[rc[0]][rc[1]]) {
				bfs(rc[0], rc[1], 0);
			}

		}
		
		sb.append(list.size()).append("\n");
		Collections.sort(list);
		
		for(int w : list) sb.append(w).append(" ");

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int row, int col, int count) {

		visited[row][col] = true;

		Deque<int[]> que = new ArrayDeque<>();

		que.add(new int[] { row, col, count });

		while (!que.isEmpty()) {
			int[] rc = que.pollFirst();


			for (int i = 0; i < 4; i++) {

				int nr = rc[0] + dr[i];
				int nc = rc[1] + dc[i];

				if (nr >= 0 && nr < M && nc >= 0 && nc < N && matrix[nr][nc] == 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					que.add(new int[] { nr, nc, count++});
				}

			}

			if (que.isEmpty())
				list.add(count+1);

		}

	}
}