import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			String[] AB = br.readLine().split(" ");
			int A = Integer.parseInt(AB[0]);
			int B = Integer.parseInt(AB[1]);

			list[B].add(A);
		}

		int maxCount = 0;
		List<Integer> result = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			boolean[] visited = new boolean[N + 1];
			visited[i] = true;
			int count = bfs(i, visited);

			if (count > maxCount) {
				maxCount = count;
				result.clear();
				result.add(i);
			} else if (count == maxCount) {
				result.add(i);
			}
		}

		for (int n : result) {
			sb.append(n).append(" ");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs(int start, boolean[] visited) {

		Deque<Integer> q = new ArrayDeque<>();
		q.add(start);

		int count = 0;

		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int w : list[curr]) {
				if (!visited[w]) {
					visited[w] = true;
					q.add(w);
					count++;
				}
			}
		}

		return count;
	}
}