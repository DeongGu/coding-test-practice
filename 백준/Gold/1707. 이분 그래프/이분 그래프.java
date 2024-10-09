import java.io.*;
import java.util.*;

public class Main {
	
	static List<Integer>[] list;
	static int[] colors;
	static boolean result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int K = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < K; tc++) {

			String[] VE = br.readLine().split(" ");

			int V = Integer.parseInt(VE[0]);
			int E = Integer.parseInt(VE[1]);
			
			list = new ArrayList[V+1];
			colors = new int[V+1];
			result = true;
			
			for(int i = 1; i <= V; i++) list[i] = new ArrayList<>();

			for (int i = 0; i < E; i++) {
				String[] uv = br.readLine().split(" ");
				int u = Integer.parseInt(uv[0]);
				int v = Integer.parseInt(uv[1]);
				
				list[u].add(v);
				list[v].add(u);
			}
			
			for(int i = 1; i <= V; i++) {
				
				if(colors[i] == 0) {					
					result = bfs(i);
					if(!result) break;
				}
			}
			
			if(result) {				
				sb.append("YES").append("\n");
			}else {
				sb.append("NO").append("\n");
			}
		}
		
		

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static boolean bfs(int v) {
		
		Deque<Integer> q = new ArrayDeque<>();
		q.add(v);
		
		colors[v] = 1;
		
		while(!q.isEmpty()) {
			
			int curr = q.pollFirst();
			
			for (int w : list[curr]) {
				if (colors[w] == 0) {
					colors[w] = -colors[curr];
					q.add(w);
				}else if(colors[w] == colors[curr]) {
					return false;
				}
			}
			
		}

		return true;

	}

}