import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		List<Integer>[] list = new ArrayList[N + 1];
		List<int[]> result = new ArrayList<>();
		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		while (true) {
			String[] AB = br.readLine().split(" ");
			int A = Integer.parseInt(AB[0]);
			int B = Integer.parseInt(AB[1]);

			if (A == -1 && B == -1)
				break;

			list[A].add(B);
			list[B].add(A);
		}

		for (int S = 1; S <= N; S++) {

			int d = bfs(N, S, list);

			min = Math.min(min, d);

			result.add(new int[] { S, d });
		}

		Collections.sort(result, Comparator.comparingInt(a -> a[1]));
		
		int count = 0;
		String member = "";

		for (int[] w : result) {
			if(w[1] == min) {
				count++;
				member += Integer.toString(w[0]) + " ";
			}
		}

		sb.append(min).append(" ").append(count).append("\n").append(member);
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs(int n, int s, List<Integer>[] list) {

		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { s, 0 });
		int distance = 0;

		boolean[] visited = new boolean[n + 1];
		visited[s] = true;

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();
			int start = curr[0];
			int dist = curr[1];

			for (int w : list[start]) {

				if (!visited[w]) {
					visited[w] = true;
					queue.add(new int[] { w, dist + 1 });
					distance = dist + 1;
				}
			}

		}

		return distance;
	}
}