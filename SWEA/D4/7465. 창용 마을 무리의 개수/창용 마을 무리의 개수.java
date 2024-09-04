import java.io.*;

public class Solution {

	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			String[] NM = br.readLine().split(" ");

			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);

			p = new int[N + 1];

			// make-set
			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}

			for (int i = 0; i < M; i++) {
				String[] fs = br.readLine().split(" ");
				int f = Integer.parseInt(fs[0]);
				int s = Integer.parseInt(fs[1]);

				union(f, s);
			}

			int result = 0;
			for (int i = 1; i <= N; i++) {
				if (p[i] == i) {
					result++;
				}
			}

			sb.append("#").append(tc + 1).append(" ").append(result).append("\n");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}

	// find-set
	static int find(int x) {
		if (p[x] == x) {
			return x;
		} else {
			return p[x] = find(p[x]);
		}
	}

	// union
	static void union(int x, int y) {
		p[find(y)] = find(x);
	}
}