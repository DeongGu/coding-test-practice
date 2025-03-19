import java.io.*;
import java.util.*;

public class Main {

	static int A, B, N, M;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] ABNM = br.readLine().split(" ");
		A = Integer.parseInt(ABNM[0]);
		B = Integer.parseInt(ABNM[1]);
		N = Integer.parseInt(ABNM[2]);
		M = Integer.parseInt(ABNM[3]);

		visited = new boolean[100001];

		sb.append(bfs());

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();

	}

	static int bfs() {

		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { N, 0 });

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			if (curr[0] == M)
				return curr[1];

			int p = curr[0] + 1;
			int m = curr[0] - 1;
			int pa = curr[0] + A;
			int ma = curr[0] - A;
			int pb = curr[0] + B;
			int mb = curr[0] - B;
			int xa = curr[0] * A;
			int xb = curr[0] * B;

			if (xa >= 0 && xa < 100001 && !visited[xa]) {
				visited[xa] = true;
				queue.add(new int[] { xa, curr[1] + 1 });
			}
			if (xb >= 0 && xb < 100001 && !visited[xb]) {
				visited[xb] = true;
				queue.add(new int[] { xb, curr[1] + 1 });
			}

			if (p >= 0 && p < 100001 && !visited[p]) {
				visited[p] = true;
				queue.add(new int[] { p, curr[1] + 1 });
			}
			if (m >= 0 && m < 100001 && !visited[m]) {
				visited[m] = true;
				queue.add(new int[] { m, curr[1] + 1 });
			}
			if (pa >= 0 && pa < 100001 && !visited[pa]) {
				visited[pa] = true;
				queue.add(new int[] { pa, curr[1] + 1 });
			}
			if (pb >= 0 && pb < 100001 && !visited[pb]) {
				visited[pb] = true;
				queue.add(new int[] { pb, curr[1] + 1 });
			}
			if (ma >= 0 && ma < 100001 && !visited[ma]) {
				visited[ma] = true;
				queue.add(new int[] { ma, curr[1] + 1 });
			}
			if (mb >= 0 && mb < 100001 && !visited[mb]) {
				visited[mb] = true;
				queue.add(new int[] { mb, curr[1] + 1 });
			}

		}

		return -1;
	}
}