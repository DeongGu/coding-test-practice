import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static String[][] matrix;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] RC = br.readLine().split(" ");
		R = Integer.parseInt(RC[0]);
		C = Integer.parseInt(RC[1]);

		matrix = new String[R][C];
		visited = new boolean[R][C];
		Queue<int[]> queue = new ArrayDeque<>();
		
		int[] result = new int[2];

		for (int r = 0; r < R; r++) {
			String[] s = br.readLine().split("");
			for (int c = 0; c < C; c++) {
				matrix[r][c] = s[c];
				if (!matrix[r][c].equals("#")) {
					queue.add(new int[] { r, c });
				} else {
					visited[r][c] = true;
				}
			}
		}
		
		while (!queue.isEmpty()) {

			int[] curr = queue.poll();

			if (!visited[curr[0]][curr[1]]) {
				int[] res = bfs(curr[0], curr[1]);
				result[0] += res[0];
				result[1] += res[1];
			}

		}

		sb.append(result[0]).append(" ").append(result[1]);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static int[] bfs(int sr, int sc) {
		int sheep = 0;
		int wolf = 0;
		
		if(matrix[sr][sc].equals("v")) {
			wolf++;
		}else if(matrix[sr][sc].equals("k")) {
			sheep++;
		}

		Deque<int[]> q = new ArrayDeque<>();
		visited[sr][sc] = true;

		q.add(new int[] { sr, sc });

		int[] remain = new int[2];

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];

				if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {
									
					if(matrix[nr][nc].equals("v")) {
						wolf++;
					} else if(matrix[nr][nc].equals("k")) {
						sheep++;
					}
					
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}
			}
		}
		
		if(sheep > wolf) {
			remain[0] = sheep;
			remain[1] = 0;
		}else {
			remain[0] = 0;
			remain[1] = wolf;
		}

		return remain;
	}
}