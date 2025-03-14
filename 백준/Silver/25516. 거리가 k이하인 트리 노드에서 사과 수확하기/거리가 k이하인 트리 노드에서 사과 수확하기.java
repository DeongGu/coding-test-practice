import java.io.*;
import java.util.*;

public class Main {

	static int n, k, result;
	static int[] apples;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] nk = br.readLine().split(" ");
		n = Integer.parseInt(nk[0]);
		k = Integer.parseInt(nk[1]);
		apples = new int[n];
		result = 0;

		list = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			String[] pc = br.readLine().split(" ");
			int p = Integer.parseInt(pc[0]);
			int c = Integer.parseInt(pc[1]);

			list[p].add(c);
			list[c].add(p);
		}

		String[] a = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			apples[i] = Integer.parseInt(a[i]);
		}

		bfs(0);

		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int start) {

		Deque<int[]> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[n];
		visited[start] =true;
		queue.add(new int[] { start, 0 });

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();
			int v = curr[0];
			int l = curr[1];

			if (l <= k) {
				result += apples[v];
			}

			for (int w : list[v]) {

				if (!visited[w]) {
					visited[w] = true;
					queue.add(new int[] { w, l + 1 });
				}
			}

		}

	}

}