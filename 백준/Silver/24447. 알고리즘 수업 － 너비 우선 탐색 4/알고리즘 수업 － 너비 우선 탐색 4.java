import java.io.*;
import java.util.*;

public class Main {

	static int N, M, R;
	static int[] d, t;
	static boolean[] visited;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NMR = br.readLine().split(" ");
		N = Integer.parseInt(NMR[0]);
		M = Integer.parseInt(NMR[1]);
		R = Integer.parseInt(NMR[2]);

		list = new ArrayList[N + 1];

		d = new int[N+1];
		
		 Arrays.fill(d, -1);
		 
		t = new int[N+1];
		visited = new boolean[N + 1];
		
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
		
		long result = 0;
		
		for(int i = 1; i <= N; i++) {
			if(d[i] != -1 && t[i] != 0) {
				result += (long) d[i] * t[i];
			}
		}
		
		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int start) {

		Deque<Integer> q = new ArrayDeque<>();
		int order = 1;
		visited[start] = true;
		d[start] = 0;
        t[start] = order++;
		q.add(start);

		while (!q.isEmpty()) {
			int curr = q.poll();
			
			Collections.sort(list[curr]);

			for (int w : list[curr]) {

				if (!visited[w]) {
					visited[w] = true;
					d[w] = d[curr] + 1;
					t[w] = order++; 
					q.add(w);
				}

			}

		}
	}
}