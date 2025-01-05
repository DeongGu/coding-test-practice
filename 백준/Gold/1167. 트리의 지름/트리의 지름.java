import java.io.*;
import java.util.*;

public class Main {

	static List<int[]>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int V = Integer.parseInt(br.readLine());

		list = new ArrayList[V + 1];
		
		visited = new boolean[V+1];

		for (int i = 0; i < V + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < V; i++) {

			String[] vvs = br.readLine().split(" ");

			int v = Integer.parseInt(vvs[0]);

			for (int j = 1; j < vvs.length; j += 2) {

				if (Integer.parseInt(vvs[j]) == -1)
					break;

				list[v].add(new int[] { Integer.parseInt(vvs[j]), Integer.parseInt(vvs[j + 1]) });
			}

		}

		int[] result1 = dfs(1);
		
		Arrays.fill(visited, false);
		
		int[] result2 = dfs(result1[0]);

		sb.append(result2[1]);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static int[] dfs(int v) {

		visited[v] = true;
		int max = 0;
		int end = v;

		for (int[] curr : list[v]) {
			int nv = curr[0];
			int d = curr[1];

			if (!visited[nv]) {
				int[] result = dfs(nv);
				int nd = result[1] + d;

				if (nd > max) {
					max = nd;
					end = result[0];
				}

			}

		}

		return new int[] { end, max };
	}

}