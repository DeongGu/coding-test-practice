import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] result;
	static List<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		result = new int[N + 1];

		list = new ArrayList[N + 1];

		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			String[] nodes = br.readLine().split(" ");
			list[Integer.parseInt(nodes[0])].add(Integer.parseInt(nodes[1]));
			list[Integer.parseInt(nodes[1])].add(Integer.parseInt(nodes[0]));
		}

		bfs(1);

		for (int i = 2; i <= N; i++) {
			sb.append(result[i]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int v) {

		visited[v] = true;

		Deque<Integer> q = new ArrayDeque<>();

		q.add(v);

		while (!q.isEmpty()) {

			int curr = q.pollFirst();

			for (int w : list[curr]) {

				if (!visited[w]) {
					visited[w] = true;
					q.add(w);
				}

				if (result[w] == 0)
					result[w] = curr;

			}
		}

	}
}
