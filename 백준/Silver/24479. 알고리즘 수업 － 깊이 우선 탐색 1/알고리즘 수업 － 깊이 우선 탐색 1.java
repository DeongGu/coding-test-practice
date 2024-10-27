import java.io.*;
import java.util.*;

public class Main {

	static boolean result;
	static int N, M, R, count;
	static List<Integer>[] list;
	static boolean[] visited;
	static int[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NMR = br.readLine().split(" ");
		N = Integer.parseInt(NMR[0]);
		M = Integer.parseInt(NMR[1]);
		R = Integer.parseInt(NMR[2]);
		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		
		count = 1;
		check = new int[N+1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {

			String[] uv = br.readLine().split(" ");
			int u = Integer.parseInt(uv[0]);
			int v = Integer.parseInt(uv[1]);

			list[u].add(v);
			list[v].add(u);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}

		dfs(R);

		for (int i = 1; i <= N; i++) {
			sb.append(check[i]).append("\n");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int start) {
		visited[start] = true;

		check[start] = count++;
		
		for (int w : list[start]) {
			if (!visited[w]) {
				dfs(w);
			}
		}

	}
}