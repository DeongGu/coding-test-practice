import java.io.*;
import java.util.*;

public class Main {

	static boolean[] visited;
	static int count;
	static String result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		visited = new boolean[1000001];
		bfs(N);

		sb.append(count).append("\n").append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int v) {
		Deque<int[]> q = new ArrayDeque<>();
		Deque<String> que = new ArrayDeque<>();

		visited[v] = true;

		q.add(new int[] { v, 0 });
		que.add(Integer.toString(v) + " ");

		while (!q.isEmpty()) {

			int[] curr = q.poll();
			String currs = que.poll();

			if (curr[0] == 1) {
				count = curr[1];
				result = currs;
				break;
			}

			if (curr[0] % 3 == 0 && !visited[curr[0] / 3]) {
				visited[curr[0] / 3] = true;
				q.add(new int[] { curr[0] / 3, curr[1] + 1 });
				que.add(currs + Integer.toString(curr[0] / 3) + " ");
			}

			if (curr[0] % 2 == 0 && !visited[curr[0] / 2]) {
				visited[curr[0] / 2] = true;
				q.add(new int[] { curr[0] / 2, curr[1] + 1 });
				que.add(currs + Integer.toString(curr[0] / 2) + " ");
			}

			if (curr[0] - 1 > 0 && !visited[curr[0] - 1]) {
				visited[curr[0] - 1] = true;
				q.add(new int[] { curr[0] - 1, curr[1] + 1 });
				que.add(currs + Integer.toString(curr[0] - 1)+ " ");
			}

		}
	}

}