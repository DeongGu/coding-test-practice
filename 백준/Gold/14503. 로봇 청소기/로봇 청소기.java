import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		int[][] matrix = new int[N][M];

		String[] crccd = br.readLine().split(" ");
		int cr = Integer.parseInt(crccd[0]);
		int cc = Integer.parseInt(crccd[1]);
		int d = Integer.parseInt(crccd[2]);

		boolean[][] visited = new boolean[N][M];
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		int result = 0;

		for (int r = 0; r < N; r++) {

			String[] s = br.readLine().split(" ");

			for (int c = 0; c < M; c++) {
				matrix[r][c] = Integer.parseInt(s[c]);
				if (Integer.parseInt(s[c]) == 1)
					visited[r][c] = true;
			}
		}

		while (true) {

			if (!visited[cr][cc]) {
				visited[cr][cc] = true;
				result++;
			}

			boolean moved = false;

			for (int i = 0; i < 4; i++) {
				d = (d + 3) % 4;
				int nr = cr + dr[d];
				int nc = cc + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && matrix[nr][nc] != 1) {
					cr = nr;
					cc = nc;
					moved = true;
					break;
				}
			}

			if (!moved) {

				int nr = cr + dr[(d + 2) % 4];
				int nc = cc + dc[(d + 2) % 4];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && matrix[nr][nc] != 1) {
					cr = nr;
					cc = nc;
				} else {
					break;
				}

			}

		}

		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}
}