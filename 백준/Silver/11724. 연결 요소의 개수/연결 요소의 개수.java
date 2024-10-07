import java.io.*;
import java.util.*;

public class Main {

	static int N, M, result;
	static boolean[] visited;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {

			String[] uv = br.readLine().split(" ");

			int u = Integer.parseInt(uv[0]);
			int v = Integer.parseInt(uv[1]);

			list[u].add(v);
			list[v].add(u);
		}

		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {				
				bfs(i);
				result++;
			}
		}

		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int v) {

		Queue<Integer> q = new LinkedList<>();

		q.add(v);
		visited[v] = true;

		while (!q.isEmpty()) {

			int curr = q.poll();

			for (int w : list[curr]) {

				if (!visited[w]) {
					q.add(w);
					visited[w] = true;

				}
			}

		}

	}

}