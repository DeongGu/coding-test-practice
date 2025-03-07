import java.io.*;
import java.util.*;

public class Main {

	static int N, M, K, X;
	static int[] result;
	static boolean[] visited;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NMKX = br.readLine().split(" ");
		N = Integer.parseInt(NMKX[0]);
		M = Integer.parseInt(NMKX[1]);
		K = Integer.parseInt(NMKX[2]);
		X = Integer.parseInt(NMKX[3]);

		result = new int[N + 1];
		visited = new boolean[N + 1];
		list = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {

			String[] se = br.readLine().split(" ");

			int s = Integer.parseInt(se[0]);
			int e = Integer.parseInt(se[1]);

			list[s].add(e);
		}

		bfs(X);

		boolean check = false;

		for (int i = 1; i <= N; i++) {
			if (result[i] == K) {
				check = true;
				sb.append(i).append("\n");
			}
		}

		if(!check) sb.append(-1);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int start) {

		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start] = true;
		result[start] = 0;
		
		while (!queue.isEmpty()) {

			int curr = queue.poll();

			for (int w : list[curr]) {

				if (!visited[w]) {
					visited[w] = true;
					result[w] = result[curr] + 1;
					queue.add(w);
				}

			}

		}

	}
}