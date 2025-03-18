import java.io.*;
import java.util.*;

public class Main {

	static int N, M, maxDistance;
	static int[] result;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		list = new ArrayList[N + 1];

		maxDistance = 0;
		result = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			String[] AB = br.readLine().split(" ");
			int A = Integer.parseInt(AB[0]);
			int B = Integer.parseInt(AB[1]);

			list[A].add(B);
			list[B].add(A);
		}

		bfs(1);

		int count = 0;
		int hide = 0;

		for (int i = 1; i <= N; i++) {
			if (result[i] == maxDistance) {
				if (hide == 0) {
					hide = i;
				}
				count++;
			}
		}

		sb.append(hide).append(" ").append(maxDistance).append(" ").append(count);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();

	}

	static void bfs(int start) {

		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		boolean[] visited = new boolean[N + 1];
		visited[start] = true;

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			for (int w : list[curr]) {
				if (!visited[w]) {
					visited[w] = true;
					result[w] = result[curr] + 1;
					maxDistance = Math.max(maxDistance, result[w]);
					queue.add(w);
				}
			}

		}

	}
}