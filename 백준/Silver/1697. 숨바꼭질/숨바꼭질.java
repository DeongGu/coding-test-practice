import java.io.*;
import java.util.*;

public class Main {

	static int N, K, result;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NK = br.readLine().split(" ");
		N = Integer.parseInt(NK[0]);
		K = Integer.parseInt(NK[1]);

		visited = new boolean[100001];

		bfs(N);
		
		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int v) {

		Queue<int[]> q = new LinkedList<>();

		q.add(new int[]{v, 0});
		visited[v] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(curr[0] == K) {
				result = curr[1];
				return;
			}

			if (curr[0]-1 >= 0 && !visited[curr[0]-1]) {
				q.add(new int[] {curr[0]-1, curr[1]+1 });
				visited[curr[0]-1] = true;
			}
			
			if (curr[0]+1 < 100001 &&!visited[curr[0]+1]) {
				q.add(new int[] {curr[0]+1, curr[1]+1 });
				visited[curr[0]+1] = true;
			}
			
			if (curr[0]*2 < 100001 && !visited[curr[0]*2]) {
				q.add(new int[] {curr[0]*2, curr[1]+1 });
				visited[curr[0]*2] = true;
			}
			
		}

	}

}