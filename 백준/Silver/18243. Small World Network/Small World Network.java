import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);

		List<Integer>[] list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < K; i++) {
			String[] AB = br.readLine().split(" ");
			int A = Integer.parseInt(AB[0]);
			int B = Integer.parseInt(AB[1]);

			list[A].add(B);
			list[B].add(A);
		}

		String result = "Small World!";

		for (int i = 1; i <= N; i++) {
			result = bfs(N, i, list);
			if (result.equals("Big World!"))
				break;
		}

		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static String bfs(int n, int s, List<Integer>[] list) {

		Deque<int[]> queue = new ArrayDeque<>();

		queue.add(new int[] {s, 0});
		boolean[] visited = new boolean[n + 1];
        visited[s] = true;

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();
			int next = curr[0];
			int dep = curr[1];
			
			if(dep > 6) return "Big World!";

			for (int w : list[next]) {
				if (!visited[w]) {
					visited[w] = true;
					queue.add(new int[] {w, dep+1});
				}
			}

		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i])
				return "Big World!";
		}
		
		return "Small World!";

	}
}