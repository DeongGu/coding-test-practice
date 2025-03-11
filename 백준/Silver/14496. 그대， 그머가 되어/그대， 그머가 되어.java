import java.io.*;
import java.util.*;

public class Main {

	static int a,b,N,M;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] ab = br.readLine().split(" ");
		a = Integer.parseInt(ab[0]);
		b = Integer.parseInt(ab[1]);
		
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		
		list = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			String[] SE = br.readLine().split(" ");
			int S = Integer.parseInt(SE[0]);
			int E = Integer.parseInt(SE[1]);
			
			list[S].add(E);
			list[E].add(S);
		}
		
		sb.append(bfs());

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs() {

		Deque<int[]> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];

		queue.add(new int[] {a, 0});
		visited[a] = true;

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();
			int start = curr[0];
			int count = curr[1];
			if(start == b) return count;
			
			for(int w : list[start]) {
				if(!visited[w]) {
					visited[w] = true;
					queue.add(new int[] {w,count+1});
				}
			}
		
		}

		return -1;
	}
}