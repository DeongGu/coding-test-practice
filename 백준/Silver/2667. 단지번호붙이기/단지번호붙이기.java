import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] matrix, resultMatrix;
	static boolean[][] visited;
	static Deque<int[]> q = new ArrayDeque<>();
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		matrix = new int[N][N];
		resultMatrix = new int[N][N];
		visited = new boolean[N][N];

		int num = 1;

		for (int r = 0; r < N; r++) {

			String[] s = br.readLine().split("");

			for (int c = 0; c < N; c++) {

				matrix[r][c] = Integer.parseInt(s[c]);

				if (Integer.parseInt(s[c]) == 1) {
					q.add(new int[] { r, c });
				}
			}
		}

		while (!q.isEmpty()) {

			int[] start = q.pollFirst();

			if (!visited[start[0]][start[1]]) {

				visited[start[0]][start[1]] = true;
				resultMatrix[start[0]][start[1]] = num;

				for (int i = 0; i < 4; i++) {

					int nr = start[0] + dr[i];
					int nc = start[1] + dc[i];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && matrix[nr][nc] == 1) {
						visited[nr][nc] = true;
						resultMatrix[nr][nc] = num;
						dfs(nr, nc, num);
					}
				}

				num++;
			}

		}

		int[] result = new int[num-1];
	
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				
				if(resultMatrix[r][c] != 0) {
					result[resultMatrix[r][c]-1]++;
				}
			}
		}

		Arrays.sort(result);
		sb.append(num-1).append("\n");
		
		for(int i = 0; i < num-1; i++) sb.append(result[i]).append("\n");
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int r, int c, int numb) {

		for (int i = 0; i < 4; i++) {

			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && matrix[nr][nc] == 1) {
				visited[nr][nc] = true;
				resultMatrix[nr][nc] = numb;
				dfs(nr, nc, numb);
			}

		}
	}

}
