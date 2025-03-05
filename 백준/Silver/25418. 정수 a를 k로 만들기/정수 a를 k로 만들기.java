import java.io.*;
import java.util.*;

public class Main {

	static int A, K;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] AK = br.readLine().split(" ");
		A = Integer.parseInt(AK[0]);
		K = Integer.parseInt(AK[1]);
		
		sb.append(bfs());

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs() {
		
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {A, 0});
		boolean[] visited = new boolean[1000001];
		
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			if(curr[0] == K) return curr[1];
			
			if(curr[0] < 1000001 && curr[0] > 0 && !visited[curr[0]]) {
				visited[curr[0]] = true;
				queue.add(new int[] {curr[0]*2 , curr[1]+1});
				queue.add(new int[] {curr[0]+1 , curr[1]+1});
			}
			
		}
		
		return 0;
		
	}
}