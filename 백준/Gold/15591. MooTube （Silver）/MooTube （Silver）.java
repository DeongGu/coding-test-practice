import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NQ = br.readLine().split(" ");
		int N = Integer.parseInt(NQ[0]);
		int Q = Integer.parseInt(NQ[1]);

		List<int[]>[] list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			String[] pqr = br.readLine().split(" ");
			int p = Integer.parseInt(pqr[0]);
			int q = Integer.parseInt(pqr[1]);
			int r = Integer.parseInt(pqr[2]);

			list[p].add(new int[] { q, r });
			list[q].add(new int[] { p, r });
		}

		for (int i = 0; i < Q; i++) {
			String[] kv = br.readLine().split(" ");
			int k = Integer.parseInt(kv[0]);
			int v = Integer.parseInt(kv[1]);

			sb.append(bfs(N, v, k, list)).append("\n");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs(int n, int s, int k, List<int[]>[] list) {
		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(s);

		boolean[] visited = new boolean[n + 1];
		visited[s] = true;

		int count = 0;

		while (!queue.isEmpty()) {

			int curr = queue.poll();

			for (int[] w : list[curr]) {

				int next = w[0];
				int usado = w[1];

				if (!visited[next] && usado >= k) {
					visited[next] = true;
					queue.add(next);
					count++;
				}
			}
		}

		return count;
	}
}
