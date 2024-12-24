import java.io.*;
import java.util.*;

public class Main {

	static int N, M;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		int[][] area = new int[N][M];

		List<int[]> list = new ArrayList<>();
		Deque<int[]> virus = new ArrayDeque<>();

		int result = 0;

		for (int r = 0; r < N; r++) {

			String[] s = br.readLine().split(" ");

			for (int c = 0; c < M; c++) {
				area[r][c] = Integer.parseInt(s[c]);

				if (area[r][c] == 0) {
					list.add(new int[] { r, c });
				} else if (area[r][c] == 2) {
					virus.add(new int[] { r, c });
				}

			}
		}

		for (int i = 0; i < list.size(); i++) {

			for (int j = i + 1; j < list.size(); j++) {

				for (int k = j + 1; k < list.size(); k++) {

					area[list.get(i)[0]][list.get(i)[1]] = 1;
					area[list.get(j)[0]][list.get(j)[1]] = 1;
					area[list.get(k)[0]][list.get(k)[1]] = 1;

					result = Math.max(bfs(area, virus), result);

					area[list.get(i)[0]][list.get(i)[1]] = 0;
					area[list.get(j)[0]][list.get(j)[1]] = 0;
					area[list.get(k)[0]][list.get(k)[1]] = 0;

				}

			}

		}

		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs(int[][] matrix, Deque<int[]> queue) {
		
		int[][] temp = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			System.arraycopy(matrix[r], 0, temp[r], 0, M);
		}
		
		Deque<int[]> q = new ArrayDeque<>(queue);

		while (!q.isEmpty()) {

			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];

			for (int i = 0; i < 4; i++) {

				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && temp[nr][nc] == 0) {
					temp[nr][nc] = 2;
					q.add(new int[] { nr, nc });
				}
			}
		}
		
		int safe = 0;

		for (int r = 0; r < N; r++) {

			for (int c = 0; c < M; c++) {

				if (temp[r][c] == 0) {
					safe++;
				}
			}
		}

		return safe;

	}

}