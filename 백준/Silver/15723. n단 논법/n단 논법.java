import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		List<Integer>[] list = new ArrayList[27];

		for (int i = 0; i <= 26; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			String[] ab = br.readLine().split(" ");
			list[ab[0].charAt(0) - 'a'].add(ab[2].charAt(0) - 'a');
		}

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			String[] ab = br.readLine().split(" ");
			int start = ab[0].charAt(0) - 'a';
			int end = ab[2].charAt(0) - 'a';
			sb.append(bfs(n, start, end, list)).append("\n");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static String bfs(int n, int s, int e, List<Integer>[] list) {
		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(s);

		boolean[] visited = new boolean[27];
		visited[s] = true;
		
		while(!queue.isEmpty()) {
			
			int curr = queue.poll();
			
			for(int w : list[curr]) {
				if(!visited[w]) {
					visited[w] = true;
					if(w == e) return "T";
					queue.add(w);
				}
			}
		}
		
		return "F";
	}
}