import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = { -2, -1, -2, -1, 1, 2, 2, 1 };
	static int[] dc = { -1, -2, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		String[] XY = br.readLine().split(" ");
		int X = Integer.parseInt(XY[0]) - 1;
		int Y = Integer.parseInt(XY[1]) - 1;

		int[][] targets = new int[M][2];
		for (int i = 0; i < M; i++) {
			String[] AB = br.readLine().split(" ");
			targets[i][0] = Integer.parseInt(AB[0]) - 1;
			targets[i][1] = Integer.parseInt(AB[1]) - 1;
		}

		int[][] distance = bfs(N, X, Y);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.append(distance[targets[i][0]][targets[i][1]]).append(" ");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static int[][] bfs(int N, int sr, int sc) {
		int[][] matrix = new int[N][N];
		for (int[] w : matrix)
			Arrays.fill(w, -1);

		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { sr, sc });
		matrix[sr][sc] = 0;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int cr = curr[0];
			int cc = curr[1];

			for (int i = 0; i < 8; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && matrix[nr][nc] == -1) {
					matrix[nr][nc] = matrix[cr][cc] + 1;
					queue.add(new int[] { nr, nc });
				}
			}
		}

		return matrix;
	}
}
