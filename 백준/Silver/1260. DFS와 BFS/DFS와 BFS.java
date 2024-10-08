import java.io.*;
import java.util.*;

public class Main {

	static int N, M, V;
	static boolean[] visited1, visited2;
	static List<Integer>[] list;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String[] NMV = br.readLine().split(" ");

		N = Integer.parseInt(NMV[0]);
		M = Integer.parseInt(NMV[1]);
		V = Integer.parseInt(NMV[2]);
		visited1 = new boolean[N + 1];
		visited2 = new boolean[N + 1];

		list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {

			String[] AB = br.readLine().split(" ");

			int A = Integer.parseInt(AB[0]);
			int B = Integer.parseInt(AB[1]);

			list[A].add(B);
			list[B].add(A);
		}
		
		for(int i = 1; i <= N; i++) Collections.sort(list[i]);

		dfs(V);
		
		sb.append("\n");

		bfs(V);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int v) {
		
		visited1[v] = true;
		sb.append(v).append(" ");
		
		for(int w : list[v]) {
			if(!visited1[w]) {
				dfs(w);
			}
		}
		

	}

	static void bfs(int v) {

		Deque<Integer> q = new ArrayDeque<>();

		q.add(v);
		visited2[v] = true;

		while (!q.isEmpty()) {

			int curr = q.poll();

			sb.append(curr).append(" ");

			for (int w : list[curr]) {

				if (!visited2[w]) {
					q.add(w);
					visited2[w] = true;
				}
			}

		}

	}

}