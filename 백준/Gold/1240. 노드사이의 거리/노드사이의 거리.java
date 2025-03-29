import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		int[][] matrix = new int[N + 1][N + 1];

		List<Integer>[] list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			String[] abd = br.readLine().split(" ");
			int a = Integer.parseInt(abd[0]);
			int b = Integer.parseInt(abd[1]);
			int d = Integer.parseInt(abd[2]);

			list[a].add(b);
			list[b].add(a);

			matrix[a][b] = d;
			matrix[b][a] = d;
		}

		for (int i = 0; i < M; i++) {
			String[] se = br.readLine().split(" ");
			int s = Integer.parseInt(se[0]);
			int e = Integer.parseInt(se[1]);

			sb.append(bfs(N, s, e, matrix, list)).append("\n");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs(int n, int s, int e, int[][] matrix, List<Integer>[] list) {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { s, 0 });

		boolean[] visited = new boolean[n + 1];
		visited[s] = true;

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();
			int v = curr[0];
			int d = curr[1];

			for (int w : list[v]) {
				if (!visited[w]) {
					visited[w] = true;
					if (w == e) {						
						return d + matrix[v][w];
					}
					queue.add(new int[] {w, d + matrix[v][w]});
				}
			}
		}

		return -1;
	}
}