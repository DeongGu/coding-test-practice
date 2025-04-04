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

		List<Integer>[] list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			String[] AB = br.readLine().split(" ");
			int A = Integer.parseInt(AB[0]);
			int B = Integer.parseInt(AB[1]);

			list[B].add(A);
		}

		int X = Integer.parseInt(br.readLine());
		sb.append(bfs(N, list, X));

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs(int n, List<Integer>[] list, int x) {

		int count = 0;

		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(x);

		boolean[] visited = new boolean[n + 1];
		visited[x] = true;

		while (!queue.isEmpty()) {

			int curr = queue.poll();

			for (int w : list[curr]) {

				if (!visited[w]) {
					visited[w] = true;
					queue.add(w);
					count++;
				}
			}

		}
		
		return count;
	}
}
