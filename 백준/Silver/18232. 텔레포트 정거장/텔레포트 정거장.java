import java.io.*;
import java.util.*;

public class Main {

	static int N, M, S, E;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		list = new ArrayList[N + 1];

		String[] SE = br.readLine().split(" ");
		S = Integer.parseInt(SE[0]);
		E = Integer.parseInt(SE[1]);

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			String[] xy = br.readLine().split(" ");
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);

			list[x].add(y);
			list[y].add(x);
		}

		sb.append(bfs());

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs() {

		Deque<int[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];

		q.add(new int[] { S, 0 });
		visited[S] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int v = curr[0];
			int t = curr[1];

			if (v == E)
				return t;

			if (v + 1 <= N && !visited[v + 1]) {
				visited[v + 1] = true;
				q.add(new int[] { v + 1, t + 1 });
			}

			if (v - 1 >= 1 && !visited[v - 1]) {
				visited[v - 1] = true;
				q.add(new int[] { v - 1, t + 1 });
			}

			for (int w : list[v]) {
				if (!visited[w]) {
					visited[w] = true;
					q.add(new int[] { w, t + 1 });
				}
			}
		}

		return -1;
	}
}
