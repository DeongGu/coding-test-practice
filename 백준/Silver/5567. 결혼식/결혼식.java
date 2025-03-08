import java.io.*;
import java.util.*;

public class Main {

	static int n, m, result;
	static int[] resultArr;
	static boolean[] visited;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		resultArr = new int[n + 1];
		visited = new boolean[n + 1];
		list = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {

			String[] se = br.readLine().split(" ");

			int s = Integer.parseInt(se[0]);
			int e = Integer.parseInt(se[1]);

			list[s].add(e);
			list[e].add(s);
		}

		bfs(1);

		boolean check = false;

		for (int i = 1; i <= n; i++) {
			if (resultArr[i] > 0 && resultArr[i] <= 2) {
				check = true;
				result++;
			}
		}

		if(!check) {
			sb.append(0);
		}else {
			sb.append(result);
		}

		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int start) {

		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start] = true;
		resultArr[start] = 0;
		
		while (!queue.isEmpty()) {

			int curr = queue.poll();

			for (int w : list[curr]) {

				if (!visited[w]) {
					visited[w] = true;
					resultArr[w] = resultArr[curr] + 1;
					queue.add(w);
				}

			}

		}

	}
}
