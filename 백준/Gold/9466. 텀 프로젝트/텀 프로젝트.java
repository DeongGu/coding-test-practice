import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static List<Integer>[] list;
	static int result;
	static boolean[] visited;
	static boolean[] finished;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			n = Integer.parseInt(br.readLine());
			String[] num = br.readLine().split(" ");

			list = new ArrayList[n + 1];
			visited = new boolean[n + 1];
			finished = new boolean[n + 1];
			result = 0;

			for (int i = 1; i <= n; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 1; i <= n; i++) {
				list[i].add(Integer.parseInt(num[i - 1]));
			}

			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					dfs(i);
				}
			}

			sb.append(n - result).append("\n");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int v) {
		visited[v] = true;

		for (int w : list[v]) {
			if (!visited[w]) {
				dfs(w);
			} else if (!finished[w]) {

				result++;
				for (int u = w; u != v; u = list[u].get(0)) {
					result++;
				}
			}
		}

		finished[v] = true;
	}
}