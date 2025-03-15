import java.io.*;
import java.util.*;

public class Main {

	static int M, S;
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] MS = br.readLine().split(":");
		M = Integer.parseInt(MS[0]);
		S = Integer.parseInt(MS[1]);

		sb.append(bfs());

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs() {

		Deque<int[]> q = new ArrayDeque<>();
		visited = new boolean[61][60][2];
		q.add(new int[] { 0, 0, 0, 0 });
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			int m = curr[0];
			int s = curr[1];
			int ing = curr[2];
			int c = curr[3];

			m += s / 60;
			s = s % 60;

			if (M == m && S == s) {
				return ing == 0 ? c + 1 : c;
			}

			if (ing == 0) {

				if (s + 10 < 60 && !visited[m][s + 10][0]) {
					visited[m][s + 10][0] = true;
					q.add(new int[] { m, s + 10, 0, c + 1 });
				}

				if (m + 1 <= 60 && !visited[m + 1][s][0]) {
					visited[m + 1][s][0] = true;
					q.add(new int[] { m + 1, s, 0, c + 1 });
				}

				if (m + 10 <= 60 && !visited[m + 10][s][0]) {
					visited[m + 10][s][0] = true;
					q.add(new int[] { m + 10, s, 0, c + 1 });
				}

				if (m == 0 && s == 0) {
					if (!visited[m][30][1]) {
						visited[m][30][1] = true;
						q.add(new int[] { m, 30, 1, c + 1 });
					}
				} else {
					if (!visited[m][s][1]) {
						visited[m][s][1] = true;
						q.add(new int[] { m, s, 1, c + 1 });
					}
				}

			} else {

				if (s + 10 < 60 && !visited[m][s + 10][1]) {
					visited[m][s + 10][1] = true;
					q.add(new int[] { m, s + 10, 1, c + 1 });
				}

				if (m + 1 <= 60 && !visited[m + 1][s][1]) {
					visited[m + 1][s][1] = true;
					q.add(new int[] { m + 1, s, 1, c + 1 });
				}

				if (m + 10 <= 60 && !visited[m + 10][s][1]) {
					visited[m + 10][s][1] = true;
					q.add(new int[] { m + 10, s, 1, c + 1 });
				}

				if (s + 30 < 60 && !visited[m][s + 30][1]) {
					visited[m][s + 30][1] = true;
					q.add(new int[] { m, s + 30, 1, c + 1 });
				}

			}

		}

		return 0;
	}
}
