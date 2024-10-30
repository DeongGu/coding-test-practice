import java.io.*;
import java.util.*;

public class Main {

	static int N, M, result;
	static boolean[] visited;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");

		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		list = new ArrayList[101];
		visited = new boolean[101];

		for (int i = 0; i <= 100; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			String[] xy = br.readLine().split(" ");
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);

			list[x].add(y);
		}
		
		for(int i = 0; i < M; i++) {
			String[] uv = br.readLine().split(" ");
			int u = Integer.parseInt(uv[0]);
			int v = Integer.parseInt(uv[1]);
			
			list[u].add(v);
		}

	
		bfs();
		
		
		sb.append(result);
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs() {

		Deque<int[]> q = new ArrayDeque<>();

		visited[1] = true;

		q.add(new int[] { 1, 0 });

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			visited[curr[0]] = true;
			
			if(curr[0] == 100) {
				result = curr[1];
				return;
			}
			
			for(int i = 1; i <= 6; i++) {
				if(curr[0] + i <= 100 && !visited[curr[0]+i]) {					
					visited[curr[0]+i] = true;
					if(list[curr[0]+i].size() == 1) {
						q.add(new int[] {list[curr[0]+i].get(0), curr[1]+1});
					}else {						
						q.add(new int[] { curr[0] + i, curr[1] + 1 });
					}
				}
			}
		}
	}
}