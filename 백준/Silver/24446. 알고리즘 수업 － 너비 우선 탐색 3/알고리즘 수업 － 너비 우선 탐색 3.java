import java.io.*;
import java.util.*;

public class Main {

	static int N, M, R;
	static List<Integer>[] list;
	static int[] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] NMR = br.readLine().split(" ");
		N = Integer.parseInt(NMR[0]);
		M = Integer.parseInt(NMR[1]);
		R = Integer.parseInt(NMR[2]);
		list = new ArrayList[N + 1];
		result = new int[N+1];

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

		bfs(R);
		
		for(int i = 1; i <= N; i++) {
			if(R == i) {
				sb.append(0).append("\n");
			}else if(result[i] == 0) {
				sb.append(-1).append("\n");
			}else {
				sb.append(result[i]).append("\n");
			}
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int start) {

		Deque<int[]> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];

		queue.add(new int[] { start, 0 });
		visited[start] = true;

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();
			int location = curr[0];
			int depth = curr[1];
			
			result[location] = depth;

			for (int w : list[location]) {
				if (!visited[w]) {
					visited[w] = true;
					queue.add(new int[] { w, depth + 1 });
				}

			}
		}

	}

}