import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int C = Integer.parseInt(br.readLine());

		for (int i = 0; i < C; i++) {

			String[] ST = br.readLine().split(" ");
			int S = Integer.parseInt(ST[0]);
			int T = Integer.parseInt(ST[1]);

			sb.append(bfs(S, T)).append("\n");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs(int s, int t) {

		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { s, t, 0 });
		boolean[][] visited = new boolean[201][201];
		visited[s][t] = true;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int cs = curr[0];
			int ct = curr[1];
			int count = curr[2];

			if (cs == ct)
				return count;

			int as = cs * 2;
			int at = ct + 3;
			if (as <= 200 && at <= 200 && !visited[as][at]) {
				queue.add(new int[] { as, at, count + 1 });
				visited[as][at] = true;
			}

			int bs = cs + 1;

			if (bs <= 200 && !visited[bs][ct]) {
				queue.add(new int[] { bs, ct, count + 1 });
				visited[bs][ct] = true;
			}
		}

		return -1;
	}
}
