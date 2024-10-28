import java.io.*;
import java.util.*;

public class Main {

	static int N, M, count, check;
	static boolean[] visited;
	static List<Integer>[] list;
	static int[] baken;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");

		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		baken = new int[N+1];
		check = Integer.MAX_VALUE;

		int result = 0;

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			String[] AB = br.readLine().split(" ");
			int A = Integer.parseInt(AB[0]);
			int B = Integer.parseInt(AB[1]);

			list[A].add(B);
			list[B].add(A);
		}

		for (int i = 1; i <= N; i++) {
			bfs(i, 0);
			visited = new boolean[N+1];
			baken[i] = count;
			check = Math.min(check, count);
		}
		
		for(int i = 1; i <= N; i++) {
			if(baken[i] == check) {
				result = i;
				break;
			}
		}
		
		sb.append(result);
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int v, int dep) {

		Deque<int[]> q = new ArrayDeque<>();

		visited[v] = true;

		q.add(new int[] { v, dep });
		
		count = 0;

		while (!q.isEmpty()) {

			int[] curr = q.poll();

			for (int w : list[curr[0]]) {
				
				if(!visited[w]) {
					visited[w] = true;
					q.add(new int[] {w, curr[1]+1});
					count += curr[1]+1;
				}
			}
		}
	}
}