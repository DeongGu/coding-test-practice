import java.io.*;
import java.util.*;

public class Main {

	static List<Integer>[] list;
	static int[][] matrix;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		matrix = new int[N][N];
		list = new ArrayList[N];
		visited = new boolean[N];

		Deque<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < N; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < N; i++) {

			String[] s = br.readLine().split(" ");

			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(s[j]);

				if (matrix[i][j] == 1) {
					list[i].add(j);
					q.add(i);
				}
			}
		}

		while (!q.isEmpty()) {
			int w = q.pollFirst();

			bfs(w);
			
			visited = new boolean[N];
		}

		for (int[] a : matrix) {
			for (int e : a)
				sb.append(e).append(" ");
			sb.append("\n");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int v) {

		Deque<Integer> que = new ArrayDeque<>();

		visited[v] = true;
		que.add(v);

		while (!que.isEmpty()) {
			int curr = que.pollFirst();

			for (int w : list[curr]) {

				if (!visited[w]) {
					visited[w] = true;
					matrix[v][w] = 1;
					que.add(w);
				}
				
				if(visited[w] && w == v) {
					matrix[v][w] = 1;
				}

			}

		}
	}

}