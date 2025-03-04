import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NK = br.readLine().split(" ");
		N = Integer.parseInt(NK[0]);
		K = Integer.parseInt(NK[1]);
		visited = new boolean[100001];

		sb.append(bfs());

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs() {

		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { N, 0 });

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();

			if (curr[0] == K) {
				return curr[1];
			}

			if (curr[0] >= 0 && curr[0] <= 100000 && !visited[curr[0]]) {
				visited[curr[0]] = true;
				queue.add(new int[] { curr[0] * 2, curr[1] });
				queue.add(new int[] { curr[0] - 1, curr[1] + 1 });
				queue.add(new int[] { curr[0] + 1, curr[1] + 1 });
			}

		}

		return 0;
	}

}