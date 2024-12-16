import java.io.*;
import java.util.*;

public class Main {
	
	static int[] arr;
	static List<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NMR = br.readLine().split(" ");
		int N = Integer.parseInt(NMR[0]);
		int M = Integer.parseInt(NMR[1]);
		int R = Integer.parseInt(NMR[2]);
		
		arr = new int[N+1];
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			
			 String[] uv = br.readLine().split(" ");
			 int u = Integer.parseInt(uv[0]);
			 int v = Integer.parseInt(uv[1]);
			 
			 list[u].add(v);
			 list[v].add(u);
			
		}
		
		for (int i = 1; i <= N; i++) {
            list[i].sort(Comparator.naturalOrder());
        }
		
		bfs(R);
		
		for(int i = 1; i <= N; i++) {
			sb.append(arr[i]).append("\n");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs(int v) {
		
		Deque<Integer> queue = new ArrayDeque<>();
		int count = 1;
		queue.add(v);
		visited[v] = true;
		arr[v] = count++;
		
		
		while(!queue.isEmpty()) {
			
			int curr = queue.poll();
			
			for(int w : list[curr]) {
				
				if(!visited[w]) {
					arr[w] = count++;
					visited[w] = true;
					queue.add(w);
				}
			}
			
		}
	}
}